package com.model.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
public class GoogleProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int rowId;
    @Column
    protected String id;
    @Column
    protected String email;
    @Column
    @JsonProperty("verified_email")
    protected Boolean verifiedEmail;
    @Column
    protected String name;
    @Column
    @JsonProperty("given_name")
    protected String givenName;
    @Column
    @JsonProperty("family_name")
    protected String familyName;
    @Column
    protected String link;
    @Column
    protected String picture;
    @Column
    protected String gender;
    @Column
    protected String locale;
    @Column
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getVerifiedEmail() {
        return verifiedEmail;
    }

    public String getName() {
        return name;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getLink() {
        return link;
    }

    public String getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public String getLocale() {
        return locale;
    }

    public String getHd() {
        return hd;
    }
}
