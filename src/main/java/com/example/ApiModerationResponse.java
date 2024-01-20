package com.example;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class ApiModerationResponse {
    final int code;
    final String msg;
    final List<String> input;

    @Override
    public String toString() {
        return "ApiBlogResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", blog=" + input +
                '}';
    }

    public ApiModerationResponse(int code, String msg, List<String> input) {
        this.code = code;
        this.msg = msg;
        this.input = input;
    }
}
