package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "jokes")
public class Joke {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "longtext")
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
