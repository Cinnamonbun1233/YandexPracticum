package JavaCore_2.Sprint_7.Theme_3.Tests.Test_3;

import java.util.function.Consumer;

public class Practicum {
    public static void main(String[] args) {
        Consumer<String> consumer = name -> System.out.println("Привет, " + name + "!");
        consumer.accept("Дарья");
    }
}