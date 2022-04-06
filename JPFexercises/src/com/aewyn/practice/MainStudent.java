package com.aewyn.practice;

public class MainStudent {
    public static void main(String[] args) {
        var student1 = new Student("Wim");
        var student2 = new Student("Frank", 16);

        student1.setScore(5);
        System.out.println(student1.getNaam() + ": " + student1.getScore());
        System.out.println(student2.getNaam() + ": " + student2.getScore());
    }
}
