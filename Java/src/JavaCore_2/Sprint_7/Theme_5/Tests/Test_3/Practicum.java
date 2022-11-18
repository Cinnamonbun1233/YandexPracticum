package JavaCore_2.Sprint_7.Theme_5.Tests.Test_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practicum {

    public static void main(String[] args) {
        List<String> cosmicTourists = new ArrayList<>();

        findLuckyPerson().ifPresent(cosmicTourists::add);
    }

    public static Optional<String> findLuckyPerson() {
        if (Math.random() <= 0.1) {
            return Optional.of("Александра");
        } else {
            return Optional.empty();
        }
    }
}