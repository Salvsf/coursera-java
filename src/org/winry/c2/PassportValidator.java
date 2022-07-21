package org.winry.c2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PassportValidator {

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get("input.txt"));

        Function<String, Map<String, String>> lineToMap = line -> Arrays.stream(line.split("\n|\\s")).map(pair -> pair.split(":"))
                .collect(Collectors.toMap(p -> p[0], p -> p[1]));
        List<Map<String, String>> passports =
                Arrays.stream(content.split("\n\n")).map(lineToMap).toList();

        Map<String, Predicate<String>> predicateMap = new HashMap<>();
        predicateMap.put("byr", s -> checkNumberBetween(s, 1920, 2002));
        predicateMap.put("iyr", s -> checkNumberBetween(s, 2010, 2020));
        predicateMap.put("eyr", s -> checkNumberBetween(s, 2020, 2030));
        predicateMap.put("hgt", s -> {
            Pattern pattern = Pattern.compile("(\\d+)(cm|in)$");
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                String height = matcher.group(1);
                String type = matcher.group(2);
                return switch (type) {
                    case "cm" -> checkNumberBetween(height, 150, 193);
                    case "in" -> checkNumberBetween(height, 59, 76);
                    default -> false;
                };
            } else return false;
        });
        predicateMap.put("hcl", s -> s.matches("#[\\d|a-f]{6}"));
        predicateMap.put("ecl", s -> s.matches("amb|blu|brn|gry|grn|hzl|oth"));
        predicateMap.put("pid", s -> s.matches("^(?!0+$)0\\d{8}$"));

        Predicate<Map<String, String>> passportValidator = p -> p.keySet().containsAll(predicateMap.keySet());
        long count = passports.stream().filter(passportValidator).count();
        System.out.println(count);

        Predicate<Map<String, String>> passportValidator2 =
                p -> predicateMap.entrySet().stream().allMatch(e -> e.getValue().test(p.getOrDefault(e.getKey(), "")));
        long count2 = passports.parallelStream().filter(passportValidator2).count();
        System.out.println(count2);

    }

    private static boolean checkNumberBetween(String s, int min, int max) {
        try {
            int i = Integer.parseInt(s);
            return i >= min && i <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
