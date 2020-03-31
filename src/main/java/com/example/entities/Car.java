package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name= "nickname")
    @Column
    private String nickname;
//    @NotBlank(message="model is required.")
    @Column
    private String model;
//    @NotBlank(message="year is required.")
    @Column
    private String year;
//    @NotBlank(message="driver is required.")
    @Column
    private String driver;
//    @NotBlank(message="status is required.")
    @Column
    private String status;
//    @NotBlank(message="top_speed is required.")
    @Column
    private int top_speed;


    public Car(){};

    public Car(Long id, String nickname, String model, String year, String driver, String status, int top_speed) {
        this.id = id;
        this.nickname = nickname;
        this.model = model;
        this.year = year;
        this.driver = driver;
        this.status = status;
        this.top_speed = top_speed;
    }


    public Car(String nickname, String model, String year, String driver, String status, int top_speed) {
        this.id = id;
        this.nickname = nickname;
        this.model = model;
        this.year = year;
        this.driver = driver;
        this.status = status;
        this.top_speed = top_speed;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(int top_speed) {
        this.top_speed = top_speed;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", driver='" + driver + '\'' +
                ", status='" + status + '\'' +
                ", top_speed=" + top_speed +
                '}';
    }
}
