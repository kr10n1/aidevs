package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class SearchDto {
    private String title;
    private String url;
    private String info;
    private String date;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
