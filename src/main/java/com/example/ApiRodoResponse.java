package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiRodoResponse {
    public final String msg;
    public final String hint1;

    public ApiRodoResponse(String msg, String hint1) {
        this.msg = msg;
        this.hint1 = hint1;
    }
}
