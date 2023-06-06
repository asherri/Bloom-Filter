package org.bloom.filter.dataset;

import org.bloom.filter.BloomFilter;

import java.util.HashMap;
import java.util.Map;

public class DataSetGenerator {
    private static final int DATASET_SIZE = 10_000;
    private static final int EXISTED_DATASET = DATASET_SIZE / 2;
    private final String[] dataset;
    private final Map<String, Boolean> datasetNotExists;
    private final BloomFilter bloom;

    public DataSetGenerator(BloomFilter bloom) {
        this.bloom = bloom;
        dataset = new String[DATASET_SIZE];
        datasetNotExists = new HashMap<>();
    }


    public void generateIntoBloomFilter() {
        for (int i = 0; i < EXISTED_DATASET; i++) {
            String s = RandomString.randomStringSimple();
            dataset[i] = s;
            bloom.add(s);
        }
    }

    public void generateOutOfBloomFilter() {
        for (int i = EXISTED_DATASET; i < DATASET_SIZE; i++) {
            String s = RandomString.randomStringSimple();
            dataset[i] = s;
            datasetNotExists.put(s, false);
        }
    }

    public double calculateFalsePositiveRate() {
        int falsePositive = 0;

        for (String key : dataset) {
            if (bloom.exists(key)) {
                if (datasetNotExists.containsKey(key))
                    falsePositive++;
            }
        }
        reset();

        return ((double) falsePositive / dataset.length) * 100;
    }

    private void reset() {
        datasetNotExists.clear();
    }
}
