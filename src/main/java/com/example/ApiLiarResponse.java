package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiLiarResponse {
    final String message;
    final String hint1;
    final String hint2;
    final String hint3;

    public ApiLiarResponse(String message, String hint1, String hint2, String hint3) {
        this.message = message;
        this.hint1 = hint1;
        this.hint2 = hint2;
        this.hint3 = hint3;
    }

    @Override
    public String toString() {
        return "ApiLiarResponse{" +
                "message='" + message + '\'' +
                ", hint1='" + hint1 + '\'' +
                ", hint2='" + hint2 + '\'' +
                ", hint3='" + hint3 + '\'' +
                '}';
    }
}
