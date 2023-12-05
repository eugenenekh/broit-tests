package com.broit.utils;

import java.util.Optional;
import java.util.regex.Pattern;

public class RegexUtils {

    private RegexUtils() {}

    public static Optional<Integer> getNumber(String str) {
        var pattern = Pattern.compile(".*(?<number>\\d+).*");
        var matcher = pattern.matcher(str);

        if (matcher.find()) {
            return Optional.of(Integer.parseInt(matcher.group("number")));
        }

        return Optional.empty();
    }
}
