package com.trongdeptrai.demorecyclertab.Model;

public class Dog {
    private String mName, mAge;

    public Dog(String name, String age) {
        this.mName = name;
        this.mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        this.mAge = age;
    }
}
