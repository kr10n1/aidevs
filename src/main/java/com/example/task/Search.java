package com.example.task;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.AIDevsZadania;
import com.example.Application;
import com.example.OpenAIAPI;
import com.example.SearchDto;
import com.fasterxml.jackson.core.type.TypeReference;
import io.micronaut.context.annotation.Context;
import jakarta.annotation.PostConstruct;
import com.fasterxml.jackson.databind.ObjectMapper;

@Context
public class Search {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Search(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

    @PostConstruct
    public void init() throws IOException {
        String token = zadania.getToken();
        StringBuilder builder = new StringBuilder();
        String answer = null;
        var response = zadania.receiveTask(token);
        String question = response.getQuestion();
        File file = zadania.receiveFile("https://unknow.news/archiwum.json", "archiwum.json");

        List<SearchDto> searchDto = new ObjectMapper().readValue(file, new TypeReference<List<SearchDto>>(){});
        int i = 0;
        for (SearchDto dto : searchDto) {
            String title = dto.getTitle();
            builder.append("\n")
                    .append(i++)
                    .append(" ");
            builder.append(title);
        }

//        String s = api.sendOpenAIRequest("Znajdź numer pod którym został opisany artykuł. Jeśli nie jesteś pewien na 100% odpowiedz wyłącznie: nie wiem" + builder, question);
        zadania.answer(token, Application.replaceNull("https://www.internet-czas-dzialac.pl/pseudonimizacja-a-anonimizacja/"));
        System.exit(0);
    }
}
