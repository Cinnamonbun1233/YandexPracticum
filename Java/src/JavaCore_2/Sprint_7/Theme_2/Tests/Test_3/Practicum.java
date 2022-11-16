package JavaCore_2.Sprint_7.Theme_2.Tests.Test_3;

import java.util.function.Supplier;

public class Practicum {

    public static void main(String[] args) {

        Supplier<Double> randomDoubleSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random(); // случайное число от 0 до 1
            }
        };

        Double supplied = randomDoubleSupplier.get();
        System.out.println(supplied);
    }
}