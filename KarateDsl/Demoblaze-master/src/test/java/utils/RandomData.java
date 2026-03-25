package utils;

import net.datafaker.Faker;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RandomData {
    static Instant instant = Instant.now();

    public static String randomFirstName() {
        Faker fake = new Faker();
        return fake.name().firstName();
    }

    public static String randomLastName() {
        Faker fake = new Faker();
        return fake.name().lastName();
    }

    public static String randomNumber() {
        Faker fake = new Faker();
        return fake.number().numberBetween(100, 1000) + "";
    }
}
