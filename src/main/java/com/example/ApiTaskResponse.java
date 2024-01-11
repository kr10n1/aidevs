package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class ApiTaskResponse {

    @JsonProperty("code")
    private int code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("input")
    private List<String> input;

    @JsonProperty("question")
    private String question;

    // Default constructor for Jackson deserialization
    public ApiTaskResponse() {
    }

    public ApiTaskResponse(int code, String msg, List<String> input, String question) {
        this.code = code;
        this.msg = msg;
        this.input = input;
        this.question = question;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", input=" + input +
                ", question='" + question + '\'' +
                '}';
    }
}
