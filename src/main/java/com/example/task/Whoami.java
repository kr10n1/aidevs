package com.example.task;

import com.example.AIDevsZadania;
import com.example.ApiWhoAmiResponse;
import com.example.Application;
import com.example.OpenAIAPI;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;
import jakarta.annotation.PostConstruct;

@Context
@Requires(env = "whoami")
public class Whoami {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Whoami(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

//    @PostConstruct
//    public void init() {
//        String token = zadania.getToken();
//        boolean answered = false;
//        StringBuilder builder = new StringBuilder();
//        String answer = null;
//        do {
//            ApiWhoAmiResponse response = zadania.receiveTask(token);
//            builder.append(response.hint).append(". ");
//            answer = api.sendOpenAIRequest("Znajdź imię i nazwisko osoby którą opisuję. Jesli nie jesteś pewien na 100% odpowiedz wyłącznie: nie wiem", builder.toString());
//            if(answer.toLowerCase().contains("nie wiem")) {
//                token = zadania.getToken();
//                continue;
//            }
//            answered = true;
//        } while(!answered);
//        zadania.answer(token, "\"" + Application.replaceNull(answer) +"\"");
//        System.exit(0);
//    }
}
