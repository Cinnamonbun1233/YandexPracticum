package JavaCore_2.Sprint_7.Theme_4.Tests.Test_2;

import java.util.function.Predicate;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Predicate<Person> isOlderPredicate() {
        // реализуйте этот метод здесь
        return person -> person.getAge() > this.age;
    }

    public int getAge() {
        return age;
    }
}

public class Practicum {

    public static void main(String[] args) {
        Person kostya = new Person("Костя", 5);

        System.out.println(kostya.isOlderPredicate().test(new Person("Старше", 10))); // true
        System.out.println(kostya.isOlderPredicate().test(new Person("Младше", 3))); // false
    }
}