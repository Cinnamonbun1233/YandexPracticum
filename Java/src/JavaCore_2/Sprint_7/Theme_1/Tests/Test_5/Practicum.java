package JavaCore_2.Sprint_7.Theme_1.Tests.Test_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practicum {

    public static void main(String[] args) throws Exception {

        List<String> people = new ArrayList<>(List.of(
                "Мария Зуева",
                "Анна Дарк",
                "Кирилл Филимонов",
                "Ева Пинк"
        ));

        // <-- напишите свой код здесь
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(o1.indexOf(" ")).length() - o2.substring(o2.indexOf(" ")).length();

            }
        };

        Collections.sort(people, comparator);
        System.out.println(people);
    }
}