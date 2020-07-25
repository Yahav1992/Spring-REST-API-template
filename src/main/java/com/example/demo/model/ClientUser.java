package com.example.demo.model;

import lombok.Getter;

@Getter
public class ClientUser {
    private final String token;
    private final String userName;

    public ClientUser(AuthenticatedUser usr) {
        this.token = usr.getToken();
        this.userName = usr.getUserName();
    }

}
