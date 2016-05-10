package com.googleAuthentication;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory.expect;

/**
 * Performs a POST on check token endpoint URL.
 */
@Service
public class GoogleTokenServices extends RemoteTokenServices {
    private static Logger LOGGER = LoggerFactory.getLogger(GoogleTokenServices.class);

    private final String checkTokenEndpointUrl;
    private final AccessTokenConverter tokenConverter;
    private final RestTemplate restTemplate;
    private final String authorizationHeaderValue;

    @Autowired
    public GoogleTokenServices(@Value("${google.check.token.endpoint.url}") final String checkTokenEndpointUrl,
                               @Value("${google.client.id}") final String clientId,
                               @Value("${google.client.secret}") final String clientSecret,
                               final AccessTokenConverter tokenConverter) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
        this.tokenConverter = tokenConverter;
        this.authorizationHeaderValue = getAuthorizationHeaderValue(clientId, clientSecret);
        this.restTemplate = new RestTemplate();

        this.restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getStatusCode() != HttpStatus.BAD_REQUEST) {
                    super.handleError(response);
                }
            }
        });
    }

    @Override
    public OAuth2Authentication loadAuthentication(final String accessToken) throws AuthenticationException, InvalidTokenException {
        expect(accessToken, "accessToken").not().toBeBlank().check();
        final Map<String, String> checkTokenResponseMap = postForMap(accessToken);
        final Map<String, String> standardizedResponseMap = getStandardizedResponseMap(checkTokenResponseMap);
        final OAuth2Authentication oAuth2Authentication = tokenConverter.extractAuthentication(standardizedResponseMap);
        return oAuth2Authentication;
    }

    private String getAuthorizationHeaderValue(final String clientId, final String clientSecret) {
        expect(clientId, "clientId").not().toBeBlank().check();
        expect(clientSecret, "clientSecret").not().toBeBlank().check();

        final String credential = String.format("%s:%s", clientId, clientSecret);

        try {
            return "Basic " + new String(Base64.encode(credential.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert String");
        }
    }

    private Map<String, String> postForMap(final String accessToken) {
        expect(accessToken, "accessToken").not().toBeBlank().check();
        final String url = String.format(checkTokenEndpointUrl, accessToken);
        final MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.set("token", accessToken);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", authorizationHeaderValue);

        final ParameterizedTypeReference<Map<String, String>> map = new ParameterizedTypeReference<Map<String, String>>() {
        };

        final Map<String, String> checkTokenEndpointResponse = ImmutableMap.copyOf(
                restTemplate
                        .exchange(url,
                                  HttpMethod.POST,
                                  new HttpEntity<MultiValueMap<String, String>>(formData, headers),
                                  map)
                        .getBody());
        if (checkTokenEndpointResponse.containsKey("error")) {
            throw new InvalidTokenException(checkTokenEndpointResponse.get("error"));
        }

        return checkTokenEndpointResponse;
    }

    private Map<String, String> getStandardizedResponseMap(final Map<String, String> responseMap) {
        expect(responseMap, "responseMap").not().toBeNull().check();
        final Map<String, String> transformedResponseMap = ImmutableMap.<String, String>builder()
                .putAll(responseMap)
                .put("client_id", responseMap.get("issued_to"))
                .put("user_name", responseMap.get("email"))
                .put("aud", responseMap.get("audience"))
                .build();
        return transformedResponseMap;
    }
}
