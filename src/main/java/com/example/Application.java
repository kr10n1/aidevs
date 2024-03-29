package com.example;

import com.theokanning.openai.embedding.Embedding;
import com.theokanning.openai.moderation.Moderation;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.runtime.Micronaut;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = Micronaut.run(Application.class, args);
    }

    static String getAnswer(List<String> strings) {
        return "[\"" + strings.stream()
                .map(s -> replaceNull(s))
                .reduce((s, s2) -> s.concat("\",\"").concat(s2)).get() + "\"]";
    }

    public static String replaceNull(String strings) {
        return strings.replace("null", "").replaceAll("[\\r\\n]", "");
    }
}


//{"answer": ["Optional[Witajcie miłośnicy pizzy! Dziś chciałabym podzielić się z Wami nie tylko przepisem na idealną pizzę, ale także kilkoma ciekawostnull","Pierwszorzędna pizza wymaga starannie dobranych składników, aby stworzyć nieodparcie smakowitą kompozycję. Oto niezbędne składniki, którenull","Robienie pizzy – jak stworzyć wspaniałą własnoręcznie zrobioną pizzę w domu

//Pizza jest jednym z najbardziej popularnych dań na całym świecie. Jejnull","Jest coś magicznego w pizzy, prawda? Smak świeżego ciasta, aromatyczne składniki i ser roztopiony na wierzchu – to wszystko sprawia, że pizzanull]"]}