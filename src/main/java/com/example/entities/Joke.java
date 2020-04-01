package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "jokes")
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "category")
      @Enumerated(EnumType.STRING)
    Category category;
    @Column(name = "longtext")
    private String longtext;


    public Joke(){};

    public Joke(Long id, String longtext) {
        this.id = id;
        this.longtext = longtext;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Joke(String longtext, Category category ){
        this.longtext = longtext;
        this.category = category;
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
