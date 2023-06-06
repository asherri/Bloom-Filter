package org.bloom.filter;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.bloom.filter.dataset.DataSetGenerator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PythonExecutionException, IOException {
        DataSetGenerator ds;
        BloomFilter bloom;


        List<Double> ratioList = new LinkedList<>();
        for (int bloomFilterSize = 1000; bloomFilterSize <= 30_000; bloomFilterSize += 1000) {
            bloom = new BloomFilter(bloomFilterSize);

            ds = new DataSetGenerator(bloom);
            ds.generateIntoBloomFilter();
            ds.generateOutOfBloomFilter();

            double ratio = ds.calculateFalsePositiveRate();
            System.out.println("ratio = " + ratio);

            ratioList.add(ratio);
        }

        Plot plot = Plot.create(PythonConfig.pythonBinPathConfig("python3"));
        plot.plot().add(ratioList);
        plot.title("False Positive Rate");
        plot.xlabel("Bloom Filter Size X 1000");
        plot.ylabel("FalsePositiveRate");
        plot.show();
    }
}
