package JavaCore_2.Sprint_7.Theme_7.Tests.Test_1;

import java.time.Instant;

public class Practicum {

    public static void main(String[] args) {

        long millis = 9_000_000_000L; // количество миллисекунд

        System.out.println(Instant.ofEpochMilli(millis)); // дата millis миллисекунд после Unix-эпохи
        System.out.println(Instant.ofEpochMilli(-millis)); // дата millis миллисекунд до Unix-эпохи
    }
}