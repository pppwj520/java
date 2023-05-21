package com.itheima.pojo;

public class course {
    private int id;
    private String name;
    private int hours;
    private int school;

    public course(int id) {
        this.id = id;
    }

    public course(String name) {
        this.name = name;
    }

    public course() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public int getSchool() {
        return school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", school=" + school +
                '}';
    }
}
