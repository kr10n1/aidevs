package com.example;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class ChatCompletionResponse {

    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    private String systemFingerprint;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getSystemFingerprint() {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }
    @Serdeable
    public static class Choice {
        final int index;
        final Message message;
        final List<String> logprobs;
        final String finishReason;

        public Choice(int index, Message message, List<String> logprobs, String finishReason) {
            this.index = index;
            this.message = message;
            this.logprobs = logprobs;
            this.finishReason = finishReason;
        }

        // Getters and setters
    }
    @Serdeable
    public static class Message {
        final  String role;
        final String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        // Getters and setters
    }
    @Serdeable
    public static class Usage {
        final int promptTokens;
        final int completionTokens;
        final int totalTokens;

        public Usage(int promptTokens, int completionTokens, int totalTokens) {
            this.promptTokens = promptTokens;
            this.completionTokens = completionTokens;
            this.totalTokens = totalTokens;
        }

        // Getters and setters
    }
}
