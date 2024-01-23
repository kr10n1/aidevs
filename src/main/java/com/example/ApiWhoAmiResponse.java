package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiWhoAmiResponse {
    public final String msg;
    public final String hint;

    public ApiWhoAmiResponse(String msg, String hint) {
        this.msg = msg;
        this.hint = hint;
    }
}
