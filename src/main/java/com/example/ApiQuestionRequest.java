package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiQuestionRequest {
    private final String question;

    public ApiQuestionRequest(String question) {
        this.question = question;
    }
}
