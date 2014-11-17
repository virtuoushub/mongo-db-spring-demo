package com.joshlong.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public final class Bookmark {

    @JsonIgnore
    @ManyToOne
    public Account account;

    @Id
    @GeneratedValue
    public Long id;

    public Bookmark() { // jpa only
    }

    public Bookmark(Account account, String uri, String description) {
        this.uri = uri;
        this.description = description;
        this.account = account;
    }

    public String uri;
    public String description;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getUri() {
        return uri;
    }
}