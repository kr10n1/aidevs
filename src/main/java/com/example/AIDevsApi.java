package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.annotation.Serdeable;

@Client("https://zadania.aidevs.pl")
public interface AIDevsApi {
    @Post("/answer/{token}")
    HttpResponse<Object> answer(String token, @Body String json);

    @Post("/token/people")
    HttpResponse<ApiTokenResponse> getToken(@Body ApiKeyRequest request);

    @Get("/task/{token}")
    HttpResponse<ApiPeopleResponse> getTask(String token);

    @Post("/task/{token}")
    HttpResponse<ApiQuestionResponse> question(ApiQuestionRequest question, String token);

    @Serdeable
    class ApiKeyRequest {
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
}
