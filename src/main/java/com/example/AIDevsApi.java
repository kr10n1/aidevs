package com.example;

import javax.print.attribute.standard.Media;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.http.MediaType.*;

@Client("https://zadania.aidevs.pl")
public interface AIDevsApi {
    @Post("/answer/{token}")
    HttpResponse<Object> answer(String token, @Body String json);

    @Post("/token/gnome")
    HttpResponse<ApiTokenResponse> getToken(@Body ApiKeyRequest request);

    @Get("/task/{token}")
    HttpResponse<ApiPeopleResponse> getTask(String token);

    @Post(value = "/task/{token}", produces = MediaType.APPLICATION_FORM_URLENCODED)
    HttpResponse<ApiQuestionResponse> question(String token, @Body String question);

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
