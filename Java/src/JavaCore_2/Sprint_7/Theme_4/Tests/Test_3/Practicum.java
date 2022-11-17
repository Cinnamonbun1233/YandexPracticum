package JavaCore_2.Sprint_7.Theme_4.Tests.Test_3;

import java.util.function.Consumer;

class Person {
    private String name;
    private String favouriteSpice;

    public Person(String name, String favouriteSpice) {
        this.name = name;
        this.favouriteSpice = favouriteSpice;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteSpice() {
        return favouriteSpice;
    }

    public Consumer<String> trySpice() {
        return spice -> {
            if (spice.length() > favouriteSpice.length()) {
                favouriteSpice = spice;
            }
        };
    }
}

public class Practicum {

    public static void main(String[] args) {
        Person person = new Person("Яна", "тмин");

        person.trySpice().accept("кориандр");
        System.out.println(person.getFavouriteSpice()); // кориандр
    }
}