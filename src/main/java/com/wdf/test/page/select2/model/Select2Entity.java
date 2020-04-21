package com.wdf.test.page.select2.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Select2Entity {
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
