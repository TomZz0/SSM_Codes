package com.wzh.pojo;

public class Player {
    String username;
    String password;
    String hobbies;
    Integer score;

    public Player() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", score=" + score +
                '}';
    }

    public Player(String username, String password, String hobbies, Integer score) {
        this.username = username;
        this.password = password;
        this.hobbies = hobbies;
        this.score = score;
    }
}
