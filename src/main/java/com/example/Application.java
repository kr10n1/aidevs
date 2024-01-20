package com.example;

import com.theokanning.openai.moderation.Moderation;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.runtime.Micronaut;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = Micronaut.run(Application.class, args);

        AIDevsZadania bean = run.getBean(AIDevsZadania.class);
        String token = bean.getToken();
        var apiTaskResponse = bean.receiveTask(token);


        OpenAIAPI openAIAPI = run.getBean(OpenAIAPI.class);

        List<String> strings = new ArrayList<>();
        for(String chapter : apiTaskResponse.input) {
            List<Moderation> response = openAIAPI.sendModerationRequest(chapter);
//            System.out.println("OpenAI Response: " + response);
            boolean flagged = response.get(0).flagged;
            String result = flagged ? "1" : "0";
            strings.add(result);
        }
        HttpResponse<Object> answer = bean.answer(token, getAnswer(strings));
        System.out.println(answer.toString());
        run.close();
        System.exit(0);
    }

    private static String getAnswer(List<String> strings) {
        return "[\"" + strings.stream()
                .map(s -> replaceNull(s))
                .reduce((s, s2) -> s.concat("\",\"").concat(s2)).get() + "\"]";
    }

    private static String replaceNull(String strings) {
        return strings.replace("null", "").replaceAll("[\\r\\n]", "");
    }
}


//{"answer": ["Optional[Witajcie miłośnicy pizzy! Dziś chciałabym podzielić się z Wami nie tylko przepisem na idealną pizzę, ale także kilkoma ciekawostnull","Pierwszorzędna pizza wymaga starannie dobranych składników, aby stworzyć nieodparcie smakowitą kompozycję. Oto niezbędne składniki, którenull","Robienie pizzy – jak stworzyć wspaniałą własnoręcznie zrobioną pizzę w domu

//Pizza jest jednym z najbardziej popularnych dań na całym świecie. Jejnull","Jest coś magicznego w pizzy, prawda? Smak świeżego ciasta, aromatyczne składniki i ser roztopiony na wierzchu – to wszystko sprawia, że pizzanull]"]}