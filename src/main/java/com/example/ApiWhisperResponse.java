package com.example;

import io.micronaut.serde.annotation.Serdeable;

import java.io.File;

@Serdeable
public class ApiWhisperResponse {
    public final String msg;

    @Override
    public String toString() {
        return "ApiWhisperResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public ApiWhisperResponse(String msg) {
        this.msg = msg;
    }
}
