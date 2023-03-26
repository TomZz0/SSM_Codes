package com.wzh.mybatis.pojo;

public class User {
    //getXXX中的xxx要和数据库中的名称一样 否则获取时获取不到结果
    //属性名可以不同 但get方法一定要同名
    private Integer id;
    private Integer age;
    private String name;
    private String password;
    private Character gender;
    private String email;

    public User() {
    }

    public User(Integer id, Integer age, String username, String password, Character gender, String email) {
        this.id = id;
        this.age = age;
        this.name = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
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
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
