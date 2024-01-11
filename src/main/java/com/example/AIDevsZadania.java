package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.inject.Inject;


public class AIDevsZadania {

    public @Nullable ApiTaskResponse receiveTask(String token) {
        HttpResponse<ApiTaskResponse> response = tokenClient.getTask(token);
        if (response.status().getCode() == 200) {
            System.out.println("Token request successful. Response: " + response.body());
        } else {
            System.out.println("Token request failed. Status code: " + response.status().getCode());
        }
        return response.body();
    }

    @Client("https://zadania.aidevs.pl")
    interface TokenClient {

        @Post("/answer/{token}")
        void answer(String token, @Body String json);

        @Post("/token/inprompt")
        HttpResponse<ApiTokenResponse> getToken(@Body ApiKeyRequest request);

        @Get("/task/{token}")
        HttpResponse<ApiTaskResponse> getTask(String token);
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

    public void answer(String token, String answer) {
        tokenClient.answer(token, "{\"answer\": \"" + answer + "\"}");
    }
}
