package ru.morev.education.model;

import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String content;

    public Message() {} // Нужен Jackson'у

    public Message(String from, String content) {
        this.from = from;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
