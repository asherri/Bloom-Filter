package org.bloom.filter.dataset;

import java.util.UUID;

public class RandomString {
    public static String randomStringSimple() {
        return UUID.randomUUID().toString();
    }
}
