package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class AIDevsZadania {

    public @Nullable ApiLiarResponse receiveTask(String token) {
        var response = AIDevsApi.getTask(token);
        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }
        return response.body();
    }
    public @Nullable ApiQuestionResponse question(String token, String question) {
        var response = AIDevsApi.question(new ApiQuestionRequest(question), token);
        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }
        return response.body();
    }

    public File receiveFile(String url, String fileName) {
        HttpRequest test = HttpRequest.newBuilder(URI.create(url)).GET().build();
        try {
            var bytes = HttpClient.newHttpClient().send(test, responseInfo -> java.net.http.HttpResponse.BodyHandlers.ofByteArray().apply(responseInfo));
            return convertByteArrayToFile(bytes.body(), fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static File convertByteArrayToFile(byte[] byteArray, String fileName) throws IOException {
        File file = new File("C:\\Dev\\" + fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(byteArray);
        }

        return file;
    }

    final AIDevsApi AIDevsApi;
    @Inject
    public AIDevsZadania(AIDevsApi AIDevsApi) {
        this.AIDevsApi = AIDevsApi;
    }
    public String getToken() {
        AIDevsApi.ApiKeyRequest apiKeyRequest = new AIDevsApi.ApiKeyRequest("23729d35-47e0-464c-8bec-b90ba5fbc994");

        HttpResponse<ApiTokenResponse> response = AIDevsApi.getToken(apiKeyRequest);

        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }

        return response.body().getToken();
    }

    public void answer(String token, String answer) {
        AIDevsApi.answer(token, "{\"answer\": " + answer + "}");
    }
}
