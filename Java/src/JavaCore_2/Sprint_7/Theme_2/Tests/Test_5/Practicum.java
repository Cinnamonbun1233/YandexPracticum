package JavaCore_2.Sprint_7.Theme_2.Tests.Test_5;

import java.util.function.Function;

public class Practicum {

    public static void main(String[] args) {

        Function<String, Integer> nameToLengthFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        String name = "Марк";
        System.out.println("Сколько букв в имени " + name + "?");
        System.out.println("Ответ: " + nameToLengthFunction.apply(name));
    }
}