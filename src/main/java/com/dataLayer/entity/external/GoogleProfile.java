package com.dataLayer.entity.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleProfile implements OauthProfile {
    protected String id;
    protected String email;
    @JsonProperty("verified_email")
    protected Boolean verifiedEmail;
    protected String name;
    @JsonProperty("given_name")
    protected String givenName;
    @JsonProperty("family_name")
    protected String familyName;
    protected String link;
    protected String picture;
    protected String gender;
    protected String locale;
    protected String hd;

    GoogleProfile() {
    }

    public GoogleProfile(GoogleProfile googleProfile) {
        this.id = googleProfile.id;
        this.email = googleProfile.email;
        this.verifiedEmail = googleProfile.verifiedEmail;
        this.name = googleProfile.name;
        this.givenName = googleProfile.givenName;
        this.familyName = googleProfile.familyName;
        this.link = googleProfile.link;
        this.picture = googleProfile.picture;
        this.gender = googleProfile.gender;
        this.locale = googleProfile.locale;
        this.hd = googleProfile.hd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(Boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
}
