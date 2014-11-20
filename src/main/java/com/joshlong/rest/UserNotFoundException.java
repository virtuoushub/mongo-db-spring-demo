package com.joshlong.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Peter Colapietro on 11/17/2014.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public final class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}

