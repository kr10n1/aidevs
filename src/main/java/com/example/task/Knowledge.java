package com.example.task;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.AIDevsZadania;
import com.example.Application;
import com.example.OpenAIAPI;
import com.example.SearchDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;
import jakarta.annotation.PostConstruct;

@Context
@Requires(env="knowledge")
public class Knowledge {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Knowledge(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

//    @PostConstruct
//    public void init() throws IOException {
//        String token = zadania.getToken();
//        StringBuilder builder = new StringBuilder();
//        String answer = null;
//        var response = zadania.receiveTask(token);
//        String question = response.getQuestion();
//
//        String s = api.sendOpenAIRequest("Odpowiedz na pytanie najkrócej jak to możliwe. Jeśli nie jesteś pewien na 100% odpowiedz wyłącznie: nie wiem" + builder, question);
//
//
////        String s = api.sendOpenAIRequest("Znajdź numer pod którym został opisany artykuł. Jeśli nie jesteś pewien na 100% odpowiedz wyłącznie: nie wiem" + builder, question);
//        zadania.answer(token, Application.replaceNull(s));
//        System.exit(0);
//    }
}
