package com.wzh.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student extends BigStudent implements Person {
    private Integer sid;

    private String sname;

    private Integer age;

    private String gender;

    private Clazz clazz;

    private String[] hobbies;

    private Map<String,Teacher> teachers;
    public Student() {

    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Integer getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", clazz=" + clazz +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", teachers=" + teachers +
                '}';
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
