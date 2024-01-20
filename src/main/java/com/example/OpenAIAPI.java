package com.example;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.embedding.Embedding;
import com.theokanning.openai.embedding.EmbeddingRequest;
import com.theokanning.openai.moderation.Moderation;
import com.theokanning.openai.moderation.ModerationRequest;
import com.theokanning.openai.service.OpenAiService;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Singleton
public class OpenAIAPI {

    final static String apiKey = "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";
    final static String apiUrl = "https://api.openai.com/v1/chat/moderations";
    final ChatCompletionHttpClient httpClient;
    final OpenAiService service;

    public OpenAIAPI(ChatCompletionHttpClient httpClient) {
        this.httpClient = httpClient;
        service = new OpenAiService(apiKey, Duration.ofSeconds(30));
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

    public List<Embedding> sendEmbeddingRequest(@NonNull String input) {
        EmbeddingRequest request =  EmbeddingRequest.builder()
                .model("text-embedding-ada-002")
                .input(Collections.singletonList(input))
                .user("adam.slomka@gmail.com")
                .build();
        return service.createEmbeddings(request).getData();
    }
    public String sendOpenAIRequest(String question, String context) {
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), question);
        final ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), context);
        messages.add(systemMessage);
        messages.add(userMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(500)
                .logitBias(new HashMap<>())
                .build();

        StringBuilder stringBuilder = new StringBuilder();
        service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(chatCompletionChunk -> stringBuilder.append(chatCompletionChunk.getChoices().get(0).getMessage().getContent()));
        return stringBuilder.toString();
    }

    public List<Moderation> sendModerationRequest(String input) {

        ModerationRequest request = ModerationRequest.builder()
                .model("text-moderation-latest")
                .input(input)
                .build();
        List<Moderation> results = service.createModeration(request)
                .results;
        return results;
    }
}
