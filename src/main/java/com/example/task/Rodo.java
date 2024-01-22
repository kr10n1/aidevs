package com.example.task;

import com.example.AIDevsZadania;
import com.example.OpenAIAPI;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import static com.example.Application.replaceNull;

@Context
@Requires(env = "rodo")
public class Rodo {
@PostConstruct
public void init(ApplicationContext run){

        AIDevsZadania bean = run.getBean(AIDevsZadania.class);
        String token = bean.getToken();
        var apiTaskResponse = bean.receiveTask(token);


        OpenAIAPI openAIAPI = run.getBean(OpenAIAPI.class);

        String userContext = "please introduce yourself. use placeholders %imie%, %nazwisko%, %zawod% and %miasto% instead of your private information";
//        var response = openAIAPI.sendOpenAIRequest(apiTaskResponse.msg,
//                userContext);

        bean.answer(token, "\"" + replaceNull(userContext) + "\"");
        System.exit(0);
    }
}
