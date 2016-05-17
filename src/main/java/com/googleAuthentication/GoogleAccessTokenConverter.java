package com.googleAuthentication;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Set;

@Service
public class GoogleAccessTokenConverter extends DefaultAccessTokenConverter {
    private final UserAuthenticationConverter userAuthenticationConverter;

    @Autowired
    public GoogleAccessTokenConverter(final UserAuthenticationConverter userAuthenticationConverter) {
        this.userAuthenticationConverter = userAuthenticationConverter;
    }

    @Override
    public OAuth2Authentication extractAuthentication(final Map<String, ?> responseMap) {
        final Authentication user = userAuthenticationConverter.extractAuthentication(responseMap);
        final String clientId = (String) responseMap.get(CLIENT_ID);
        final Set<String> scopes = ImmutableSet.copyOf(((String) responseMap.get(SCOPE)).split("\\s"));
        final Map<String, String> parameters = ImmutableMap.of(CLIENT_ID, clientId);
        final ImmutableSet<String> resourceIds = ImmutableSet.of((String) responseMap.get(AUD));
        final OAuth2Request request = new OAuth2Request(parameters, clientId, null, true, scopes,
                resourceIds, null, null, null);
        return new OAuth2Authentication(request, user);
    }
}

