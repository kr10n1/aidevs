package com.example.task;

import com.example.AIDevsZadania;
import com.example.ApiLiarResponse;
import com.example.OpenAIAPI;
import com.example.PeopleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Context;
import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Context
public class People {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public People(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

    @PostConstruct
    public void init() throws IOException {
        String token = zadania.getToken();
        File file = zadania.receiveFile("https://zadania.aidevs.pl/data/people.json", "people.json");
        var task = zadania.receiveTask(token);

        FileInputStream stream = new FileInputStream(file);
        String json = new String(stream.readAllBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        List<PeopleDto> dto = objectMapper.readValue(json,  new TypeReference<List<PeopleDto>>(){});

        String question = task.getQuestion();
        String name = api.sendOpenAIRequest("Potrzebuję wyciągnąć nazwisko z poniższego zdania. W odpowiedzi oczekuję wyłącznie nazwiska bez żadnych dodatkowych słów", question);

        List<PeopleDto> collect = dto.stream().filter(peopleDto -> peopleDto.getNazwisko().contains(name))
                .reduce(StringBuilder (peopleDtos, peopleDtos2) -> )

        api.sendOpenAIRequest("Odpowiedz na pytanie na podstawie poniższych danych: " + collect.red)
        System.exit(0);
    }
}
