package com.xxxmkxxx.common.messages;

public class Message<T> {
    private String text;
    private T object;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Message(String text, T object) {
        this.text = text;
        this.object = object;
    }
}
