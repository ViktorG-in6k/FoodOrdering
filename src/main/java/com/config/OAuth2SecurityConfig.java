package com.config;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import javax.annotation.Resource;

@Configuration
@EnableOAuth2Client
@PropertySource("classpath:messages.properties")
class OAuth2SecurityConfig {
    @Autowired
    private Environment env;

    @Resource
    @Qualifier("accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Bean
    @Scope("session")
    public OAuth2ProtectedResourceDetails googleResource() {
        final AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("google-oauth2-client");
        details.setClientId(env.getProperty("google.client.id"));
        details.setClientSecret(env.getProperty("google.client.secret"));
        details.setAccessTokenUri(env.getProperty("google.access.token.uri"));
        details.setUserAuthorizationUri(env.getProperty("google.user.authorization.uri"));
        details.setTokenName(env.getProperty("google.token.name"));
        details.setScope(ImmutableList.copyOf(env.getProperty("google.auth.scope").split(",")));
        details.setPreEstablishedRedirectUri(env.getProperty("google.preestablished.redirect.url"));
        details.setUseCurrentUri(false);
        details.setAuthenticationScheme(AuthenticationScheme.query);
        details.setClientAuthenticationScheme(AuthenticationScheme.form);

        return details;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public OAuth2RestTemplate oauth2RestTemplate() {
        OAuth2RestTemplate template =new OAuth2RestTemplate(googleResource(), new DefaultOAuth2ClientContext(accessTokenRequest));
        return template;
    }

}
