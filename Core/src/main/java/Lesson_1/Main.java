package main.java.Lesson_1;

import main.java.Lesson_1.Exercise_one.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder("Andrew","K", "S")
                .addCountry("Moscow")
                .addAddress("Pushkina 7")
                .buildPerson();

        System.out.println(person);
    }


}
