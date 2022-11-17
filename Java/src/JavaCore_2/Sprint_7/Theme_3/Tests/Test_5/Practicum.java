package JavaCore_2.Sprint_7.Theme_3.Tests.Test_5;

import java.util.List;
import java.util.function.Predicate;

public class Practicum {

    public static void main(String[] args) {

        Predicate<List<Integer>> sortedPredicate = list -> {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) return false;
            }
            return true;
        };

        List<Integer> list = List.of(4, 8, 15, 16, 23, 32);
        System.out.println("Отсортирован?");
        System.out.println(sortedPredicate.test(list));
    }
}