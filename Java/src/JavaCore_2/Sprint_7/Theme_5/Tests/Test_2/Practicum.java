package JavaCore_2.Sprint_7.Theme_5.Tests.Test_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practicum {

    public static Optional<String> longestName(List<String> names) {
        if (names.isEmpty()) {
            //return null;
            return Optional.empty(); // создание пустой обёртки
        }
        String max = names.get(0);
        for (String name : names) {
            if (name.length() > max.length()) {
                max = name;
            }
        }
        //return max
        return Optional.of(max); // создание обёртки со значением max
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Optional<String> longestOptional = longestName(names);
        if (longestOptional.isPresent()) {
            String longestName = longestOptional.get();
            System.out.println("Самое длинное имя состоит из "
                    + longestName.length() + " символов.");
        } else {
            System.out.println("Такого имени нет.");
        }
    }
}