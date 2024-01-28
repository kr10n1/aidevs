package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiPeopleResponse {
    final private String code;
    final private String msg;
    final private String data;
    final private String question;
    final private String hint1;
    final private String hint2;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getData() {
        return data;
    }

    public String getQuestion() {
        return question;
    }

    public String getHint1() {
        return hint1;
    }

    public String getHint2() {
        return hint2;
    }

    public ApiPeopleResponse(String code, String msg, String data, String question, String hint1, String hint2) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.quest = question;
        this.hint1 = hint1;
        this.hint2 = hint2;
    }
}
