package com.example.task;

import com.example.AIDevsZadania;
import com.example.OpenAIAPI;
import io.micronaut.context.annotation.Context;
import jakarta.annotation.PostConstruct;

@Context
public class Gnome {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Gnome(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }

    @PostConstruct
    public void init() {
        String token = zadania.getToken();
        zadania.receiveTask(token);
        zadania.answer(token,"czerwony");
    }
}
