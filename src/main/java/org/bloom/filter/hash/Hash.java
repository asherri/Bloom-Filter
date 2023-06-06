package org.bloom.filter.hash;

import java.nio.charset.StandardCharsets;

import static com.sangupta.murmur.Murmur3.hash_x86_32;

public class Hash {
    private static final int DEFAULT_SEED = 104729;

    private Hash() {
    }

    public static long hash(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        return hash_x86_32(bytes, bytes.length, DEFAULT_SEED);
    }
}
