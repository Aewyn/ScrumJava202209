package com.aewyn.practice;

public class Getal {
    private int x;

    public Getal(int g){
        this.setX(g);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int absoluut(){
        return Math.abs(this.x);
    }

    public int som(int a){
        return this.x+a;
    }

    public float som(float a){
        return this.x+a;
    }

    public double som(double a){
        return this.x+a;
    }

    public double toDouble(){
        return this.x;
    }

    public int add(int a){
        return this.x+=a;
    }

    public void print(){
        System.out.println(x);
    }
}
