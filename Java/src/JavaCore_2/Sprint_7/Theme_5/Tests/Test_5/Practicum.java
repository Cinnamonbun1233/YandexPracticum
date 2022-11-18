package JavaCore_2.Sprint_7.Theme_5.Tests.Test_5;

import java.util.OptionalInt;

public class Practicum {

    public static void main(String[] args) {
        int[] ages = {5, 13, 20, 5, 25, 19, 48, 11};
        OptionalInt youngest = youngestAdult(ages);
        if (youngest.isPresent()) {
            System.out.println("Возраст самого младшего совершеннолетнего: " + youngest.getAsInt());
        } else {
            System.out.println("Совершеннолетних нет.");
        }
    }

    public static OptionalInt youngestAdult(int[] ages) {
        int youngest = -1;
        for (int age : ages) {
            if (age >= 18) {
                if (youngest == -1 || age < youngest) {
                    youngest = age;
                }
            }
        }
        return youngest != -1 ? OptionalInt.of(youngest) : OptionalInt.empty();
    }
}