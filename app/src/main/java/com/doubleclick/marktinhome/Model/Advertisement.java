package com.doubleclick.marktinhome.Model;

import java.io.Serializable;

public class Advertisement implements Serializable {

    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
