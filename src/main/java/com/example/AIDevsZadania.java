package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.inject.Inject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class AIDevsZadania {

    public @Nullable ApiWhisperResponse receiveTask(String token) {
        var response = tokenClient.getTask(token);
        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }
        return response.body();
    }

    public File receiveAudioFile(String url) {
        HttpRequest test = HttpRequest.newBuilder(URI.create(url)).GET().build();
        try {
            var bytes = HttpClient.newHttpClient().send(test, responseInfo -> java.net.http.HttpResponse.BodyHandlers.ofByteArray().apply(responseInfo));
            return convertByteArrayToFile(bytes.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static File convertByteArrayToFile(byte[] byteArray) throws IOException {
        File file = new File("C:\\Dev\\mateusz.mp3");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(byteArray);
        }

        return file;
    }
    @Client("https://zadania.aidevs.pl")
    interface TokenClient {

        @Post("/answer/{token}")
        HttpResponse<Object> answer(String token, @Body String json);

        @Post("/token/whisper")
        HttpResponse<ApiTokenResponse> getToken(@Body ApiKeyRequest request);

        @Get("/task/{token}")
        HttpResponse<ApiWhisperResponse> getTask(String token);

        @Error(status = HttpStatus.BAD_REQUEST)
        default Object handleHttpError(Exception e) {
            // Handle specific HTTP errors here
            System.out.println("Error occurred: " + e.getMessage());
            return new Object();
        }
    }
    @Serdeable
    public class ApiKeyRequest {
        private String apikey;

        public ApiKeyRequest(String apikey) {
            this.apikey = apikey;
        }

        public String getApikey() {
            return apikey;
        }

        public void setApikey(String apikey) {
            this.apikey = apikey;
        }
    }

    @Inject
    TokenClient tokenClient;
    @Inject
    public AIDevsZadania(TokenClient tokenClient) {
        this.tokenClient = tokenClient;
    }
    public String getToken() {
        ApiKeyRequest apiKeyRequest = new ApiKeyRequest("23729d35-47e0-464c-8bec-b90ba5fbc994");

        HttpResponse<ApiTokenResponse> response = tokenClient.getToken(apiKeyRequest);

        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }

        return response.body().getToken();
    }

    public HttpResponse<Object> answer(String token, String answer) {
        return tokenClient.answer(token, "{\"answer\": " + answer + "}");
    }
}
