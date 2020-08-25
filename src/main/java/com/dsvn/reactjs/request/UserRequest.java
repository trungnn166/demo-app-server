package com.dsvn.reactjs.request;

import lombok.Data;

@Data
public class UserRequest {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Integer role;
    private Integer team;
    private String code;
}
