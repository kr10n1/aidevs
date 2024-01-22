package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiScraperResponse {
    public final String msg;
    public final String input;
    public final String question;

    @Override
    public String toString() {
        return "ApiScraperResponse{" +
                "msg='" + msg + '\'' +
                ", input='" + input + '\'' +
                ", question='" + question + '\'' +
                '}';
    }

    public ApiScraperResponse(String msg, String input, String question) {
        this.msg = msg;
        this.input = input;
        this.question = question;
    }
}
