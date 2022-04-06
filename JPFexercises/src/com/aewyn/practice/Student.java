package com.aewyn.practice;

public class Student {
    private String naam;
    private int score;

    public Student(String n){
        naam = n;
    }
    public Student(String n, int s){
        this(n);
        score = s;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
