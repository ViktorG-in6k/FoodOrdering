package com.googleAuthentication;

import com.model.Entity.GoogleProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class GoogleUserDetails extends GoogleProfile implements UserDetails {

    private final Collection<? extends GrantedAuthority> authorities;

    public GoogleUserDetails(final GoogleProfile googleProfile,
                             final Collection<? extends GrantedAuthority> authorities) {
        super(googleProfile);
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

