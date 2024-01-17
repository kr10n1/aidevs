package com.example;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class ApiBlogResponse {
    final int code;
    final String msg;
    final List<String> blog;

    @Override
    public String toString() {
        return "ApiBlogResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", blog=" + blog +
                '}';
    }

    public ApiBlogResponse(int code, String msg, List<String> blog) {
        this.code = code;
        this.msg = msg;
        this.blog = blog;
    }
}
