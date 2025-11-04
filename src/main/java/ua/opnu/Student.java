package ua.opnu;

import java.util.ArrayList;
import java.util.List;


public class Student {


    private final String name;
    private final int year;
    private final List<String> courses;


    private static final int TUITION_PER_YEAR = 20000;


    public Student(String name, int year) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім.");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути в діапазоні від 1 до 4.");
        }

        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }


    public void addCourse(String courseName) {

        if (courseName != null && !courseName.trim().isEmpty()) {
            this.courses.add(courseName);
        }
    }


    public void dropAll() {
        this.courses.clear();
    }


    public int getCourseCount() {
        return this.courses.size();
    }


    public String getName() {
        return this.name;
    }


    public int getTuition() {
        return this.year * TUITION_PER_YEAR;
    }


    public int getYear() {
        return this.year;
    }


    public static void main(String[] args) {

        Student student = new Student("Іван Петренко", 3);


        student.addCourse("Програмування на Java");
        student.addCourse("Бази даних");
        student.addCourse("Веб-технології");
        student.addCourse("  ");


        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());


        System.out.println(student.getName() + ": рік навчання - " + student.getYear());


        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());


        System.out.println("\nВидаляємо всі дисципліни...");
        student.dropAll();
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());


        try {
            System.out.println("\nСпроба створити студента з некоректним роком навчання...");
            Student wrongStudent = new Student("Олена Сидоренко", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
