package com.example.android.homework5_2;

class Person implements Comparable{
    String name, patronymic, surname;
    int age;

    public Person(String name, String patronymic, String surname, int age) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
