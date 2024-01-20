package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiFunctionsResponse {

    final String code; //": 0,
    final String msg; //": "send me definition of function named addUser that require 3 params: name (string), surname (string) and year of born in field named \"year\" (integer). Set type of function to \"object\"",
    final String hint1; //": "I will use this function like this: addUser({'John','Smith',1974})",
    final String hint2; //": "send this definition as correct JSON structure inside 'answer' field (as usual)"

    //{"answer": "function addUser(name: string, surname: string, year: number): object {\n  return {\n    name: name,\n    surname: surname,\n    year: year,\n  };\n}"}
    public ApiFunctionsResponse(String code, String msg, String hint1, String hint2) {
        this.code = code;
        this.msg = msg;
        this.hint1 = hint1;
        this.hint2 = hint2;
    }

    @Override
    public String toString() {
        return "ApiFunctionsResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", hint1='" + hint1 + '\'' +
                ", hint2='" + hint2 + '\'' +
                '}';
    }
}
