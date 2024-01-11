package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = Micronaut.run(Application.class, args);

        AIDevsZadania bean = run.getBean(AIDevsZadania.class);
        String token = bean.getToken();
        ApiTaskResponse apiTaskResponse = bean.receiveTask(token);

        String withoutQuestionMark = apiTaskResponse.getQuestion().replaceAll("\\?$", "");

        // Split the string into words
        String[] words = withoutQuestionMark.split("\\s+");

        String name = words[words.length - 1];

        List<String> strings = apiTaskResponse.getInput().stream().filter(s1 -> s1.contains(name)).toList();

        System.out.println(strings);

        OpenAIAPI openAIAPI = run.getBean(OpenAIAPI.class);

        ChatCompletionResponse response = openAIAPI.sendOpenAIRequest(apiTaskResponse.getQuestion(), strings.toString());
        String message = response.getChoices().stream().findFirst().get().message.content;
        System.out.println("OpenAI Response: " + message);

        bean.answer(token, message);

        run.close();
    }
}