package com.example.entities;

public class Joke {

    private Long id;
    private String longtext;


    public Joke(){};

    public Joke(Long id, String longtext) {
        this.id = id;
        this.longtext = longtext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongtext() {
        return longtext;
    }

    public void setLongtext(String longtext) {
        this.longtext = longtext;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", longtext='" + longtext + '\'' +
                '}';
    }
}
