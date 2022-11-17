package JavaCore_2.Sprint_7.Theme_3.Tests.Test_4;

import java.util.Comparator;

public class Practicum {
    public static void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
        System.out.println(comparator.compare("Привет", "Дарья!"));
    }
}