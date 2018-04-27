package com.example.android.androidlistviewadapterpractice1;

public class Animal {

    private String mName;
    private String gender;
    private int mAge;

    public Animal(String name, String gender, int age) {
        this.mName = name;
        this.gender = gender;
        this.mAge = age;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getmAge() {
        return mAge;
    }
}
