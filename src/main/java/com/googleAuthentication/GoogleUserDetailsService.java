package com.googleAuthentication;

import com.dataLayer.Implementations.GoogleProfileDao;
import com.google.common.collect.ImmutableSet;
import com.model.Entity.GoogleProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GoogleUserDetailsService implements UserDetailsService {
    private final String userInfoUrl;
    private final OAuth2RestOperations oauth2RestTemplate;

    @Autowired
    GoogleProfileDao googleProfileDao;

    @Autowired
    public GoogleUserDetailsService(@Value("${google.user.info.url}") final String userInfoUrl,
                                    final OAuth2RestOperations oauth2RestTemplate) {
        this.userInfoUrl = userInfoUrl;
        this.oauth2RestTemplate = oauth2RestTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        expect(email, "email").not().toBeBlank().check();
        GoogleProfile googleProfile = googleProfileDao.getGoogleProfileByEmail(email);
        if(googleProfile == null){
            final String url = String.format(userInfoUrl, oauth2RestTemplate.getAccessToken());
            googleProfile = oauth2RestTemplate.getForEntity(url, GoogleProfile.class).getBody();
            googleProfileDao.save(googleProfile);
        }

        return new GoogleUserDetails(googleProfile, ImmutableSet.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN")
        ));
    }
}
