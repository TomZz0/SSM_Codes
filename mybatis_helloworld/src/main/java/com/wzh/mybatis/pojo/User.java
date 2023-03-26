package com.wzh.mybatis.pojo;

public class User {
    private Integer id;
    private Integer age;
    private String name;
    private String password;
    private Character gender;
    private String email;

    public User() {
    }

    public User(Integer id, Integer age, String name, String password, Character gender, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
