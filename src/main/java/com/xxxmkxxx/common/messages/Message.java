package com.xxxmkxxx.common.messages;

public class Message<T> {
    private String text;
    private T model;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Message(String text, T model) {
        this.text = text;
        this.model = model;
    }
}
