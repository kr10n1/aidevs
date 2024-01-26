package com.example.task;

import com.example.AIDevsZadania;
import com.example.ApiScraperResponse;
import com.example.OpenAIAPI;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;
import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.Application.replaceNull;

@Context
@Requires(env = "scraper")
public class Scraper {

    final AIDevsZadania zadania;
    final OpenAIAPI api;

    public Scraper(AIDevsZadania zadania, OpenAIAPI api) {
        this.zadania = zadania;
        this.api = api;
    }


//    @PostConstruct
//    public void init() throws IOException {
//        String token = zadania.getToken();
//        var apiScraperResponse = zadania.receiveTask(token);
//        System.out.println(apiScraperResponse);
//
//        File file = zadania.receiveFile(apiScraperResponse.msg, "text_pasta_history.txt");
//        byte[] stream = new FileInputStream(file).readAllBytes();
//        String s = new String(stream);
//
//        String response = api.sendOpenAIRequest(s, apiScraperResponse.msg);
//
//        zadania.answer(token, "\"" + replaceNull(response) + "\"");
//        System.exit(0);
//
//    }
}
