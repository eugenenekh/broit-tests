package com.broit.utils;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RandomUtils {

    private RandomUtils() {}

    public static <T> T fromIterable(Iterable<T> collection) {
        var asList = StreamSupport.stream(collection.spliterator(), false)
            .collect(Collectors.toList());
        int max = asList.size();
        return asList.get(new Random().nextInt(max));
    }
}
