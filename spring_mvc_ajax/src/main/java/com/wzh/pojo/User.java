package com.wzh.pojo;

/**
 * @author wzh
 * @date 2023年03月25日 12:59
 * Description:
 */
public class User {
    private String username;
    private String password;
    private Integer age;
    private Character gender;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public User(String username, String password, Integer age, Character gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }
}
