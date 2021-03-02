package com.example.kbtg.user;

public class UserResponse {

    private int id;
    private String name;
    private int age;

    public UserResponse() {
    }

    public UserResponse (int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o.toString() == this.toString()) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format(this.getId() + ":" + this.getName()+":"+this.getAge());
    }
}
