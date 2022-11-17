package JavaCore_2.Sprint_7.Theme_3.Tests.Test_1;

import java.util.function.Consumer;

public class Practicum {

    public static void main(String[] args) {
        Consumer<String> greeter = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет, " + name + "!");
            }
        };

        greeter.accept("Дарья");
    }
}