package org.bloom.filter;

import org.bloom.filter.hash.Hash;
import sun.security.util.BitArray;

public class BloomFilter {
    private final BitArray bits;

    private final int size;

    public BloomFilter(int size) {
        this.size = size;
        bits = new BitArray(size);
    }

    public void add(String key) {

        int hash = hash(key);
        this.bits.set(hash, true);
    }


    public boolean exists(String key) {
        int hash = hash(key);
        return this.bits.get(hash);
    }

    private int hash(String key) {
        return Math.toIntExact(Hash.hash(key) % this.size);
    }

}
