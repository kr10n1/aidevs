package com.example;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;

@Singleton
public class OpenAIAPI {

    final static String apiKey = "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";
    final static String apiUrl = "https://api.openai.com/v1/chat/completions";
    final ChatCompletionHttpClient httpClient;

    public OpenAIAPI(ChatCompletionHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /*
    curl https://api.openai.com/v1/chat/completions \
      -H "Content-Type: application/json" \
      -H "Authorization: Bearer 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" \
      -d '{
         "model": "gpt-3.5-turbo",
         "messages": [{"role": "user", "content": "Say this is a test!"}],
         "temperature": 0.7
       }'
     */
    @Client(apiUrl) // replace with the actual API base URL
    interface ChatCompletionHttpClient {

        @Post
        @Header(name = "Content-Type", value = MediaType.APPLICATION_JSON)
        @Header(name = HttpHeaders.AUTHORIZATION, value = "Bearer " + apiKey)
        ChatCompletionResponse getChatCompletion(@Body String input);
    }

    public ChatCompletionResponse sendOpenAIRequest(String question, String context) {
        String requestBody = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \""+context+" "+question+"\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";
        System.out.println(requestBody);
        return httpClient.getChatCompletion(requestBody);
    }
}
