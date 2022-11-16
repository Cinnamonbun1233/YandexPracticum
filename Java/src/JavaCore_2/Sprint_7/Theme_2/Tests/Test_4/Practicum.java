package JavaCore_2.Sprint_7.Theme_2.Tests.Test_4;

import java.util.function.Predicate;

public class Practicum {
    public static void main(String[] args) {
        Predicate<String> tooLongPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 100;
            }
        };

        String name = "Агафья";
        System.out.println("Слишком ли длинное имя " + name + "?");
        System.out.println("Ответ: " + tooLongPredicate.test(name));
    }
}