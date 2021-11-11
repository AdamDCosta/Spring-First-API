package com.nology.FirstAPI.entity;

public class Message {
    private String textResponse;

    public Message() {
    }

    public Message(String textResponse) {
        this.textResponse = textResponse;
    }

    public String getTextResponse() {
        return textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }
}
