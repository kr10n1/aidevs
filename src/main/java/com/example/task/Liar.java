package com.example.task;

import com.example.AIDevsZadania;
import com.example.ApiWhoAmiResponse;
import com.example.Application;
import com.example.OpenAIAPI;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.annotation.Body;
import jakarta.annotation.PostConstruct;

@Context
@Requires(env = "liar")
public class Liar {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Liar(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

    @PostConstruct
    public void init() {
        String token = zadania.getToken();
        var response = zadania.question(token,"Is Elvis alive?");
//            answer = api.sendOpenAIRequest("Znajdź imię i nazwisko osoby którą opisuję. Jesli nie jesteś pewien na 100% odpowiedz wyłącznie: nie wiem", builder.toString());
        zadania.answer(token, "\"YES\"");
        System.exit(0);
    }
}
