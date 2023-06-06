### Bloom Filter False-Positive Ratio Test
A Bloom filter is a probabilistic data structure that efficiently determines whether an item is a member of a set. It provides quick responses with minimal memory usage. However, false positives may occur, meaning it can mistakenly indicate that an item is in the set when it is not. It guarantees that it will never mistakenly claim an item is not in the set when it actually is.

### Overview
The purpose of this test is to analyze the relationship between the false-positive ratio and the size of the Bloom filter. As the filter size increases, the false-positive ratio generally decreases. However, once a certain filter size threshold is reached, further increases in size do not lead to significant reductions in the false-positive ratio.

### Experimental Procedure
To conduct the test, we collected data from 30 iterations. 
The filter size ranged from 1000 nodes, gradually increasing to 30,000 nodes. 
In each run, we evaluated the false-positive ratio using a dataset of 1000 randomly generated keys. Out of these keys, 500 were hashed to the filter, while the remaining 500 were never inserted. 
By analyzing the false-positive ratio at each filter size increment, we observed significant drops in the ratio as the filter size increased.


Also, it includes visualized chart represents the ratio drops, checkout the below dependencies to visualize the ratio.

![BloomFilter1.png](images%2FBloomFilter1.png)

### Required libraries and framework.
- Download python: https://www.python.org/downloads/
- >$ curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
- >$ pip install numpy
- >$ pip install matplotlib


### Reference
- Wikipedia: https://en.wikipedia.org/wiki/Bloom_filter
- Youtube: <a href="https://www.youtube.com/@AsliEngineering">@AsliEngineering</a>
- Hashing function: <a href="https://github.com/sangupta/murmur">murmur</a>