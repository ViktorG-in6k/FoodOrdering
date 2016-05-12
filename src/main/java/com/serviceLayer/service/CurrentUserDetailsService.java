package com.serviceLayer.service;

import com.dataLayer.DAO.Implementations.GoogleProfileDao;
import com.google.common.collect.ImmutableSet;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.dataLayer.entity.GoogleProfile;
import com.dataLayer.entity.User;
import com.dataLayer.entity.base.OauthProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

import static com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory.expect;

/**
 * Returns user profile from Google and roles from DB (currently hardcoded).
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final String userInfoUrl;
    private final OAuth2RestOperations oauth2RestTemplate;

    @Autowired
    GoogleProfileDao googleProfileDao;

    @Autowired
    UserService userService;

    @Autowired
    public CurrentUserDetailsService(@Value("${google.user.info.url}") final String userInfoUrl,
                                     final OAuth2RestOperations oauth2RestTemplate) {
        this.userInfoUrl = userInfoUrl;
        this.oauth2RestTemplate = oauth2RestTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        if(user == null){
            final String url = String.format(userInfoUrl, oauth2RestTemplate.getAccessToken());
            OauthProfile oauthProfile = oauth2RestTemplate.getForEntity(url, GoogleProfile.class).getBody();
            user = userService.getUserFromOauthUser(oauthProfile);
            userService.saveUser(user);
        }
        return new CurrentUserDetails(user, ImmutableSet.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN")
        ));
    }
}
