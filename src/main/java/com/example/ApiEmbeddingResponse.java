package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiEmbeddingResponse {
   final String code;
   final String        msg;
   final String        hint1;
   final String        hint2;
   final String        hint3;

    @Override
    public String toString() {
        return "ApiEmbeddingResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", hint1='" + hint1 + '\'' +
                ", hint2='" + hint2 + '\'' +
                ", hint3='" + hint3 + '\'' +
                '}';
    }

    public ApiEmbeddingResponse(String code, String msg, String hint1, String hint2, String hint3) {
        this.code = code;
        this.msg = msg;
        this.hint1 = hint1;
        this.hint2 = hint2;
        this.hint3 = hint3;
    }
}
