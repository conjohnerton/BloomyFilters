// BloomFilter by John Connerton 

import java.util.*;

public class BloomFilter<T>
{
    private boolean[][] filters;
    public int[] primes = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};

    public boolean contains(T key)
    {
        // HashIt!
        int val = key.hashCode();

        // wrap this bad boy back around to 0 if we have integer overflow
        if (val < 0)
        {
            val -= Integer.MIN_VALUE;
        }

        // check each filter to see if the key is present in each of them
        for (int i = 0; i < this.filters.length; i++)
        {
            int index = val % this.filters[i].length;

            if (this.filters[i][index] == false)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        if (args.length < 1) 
        {
            System.out.println("Format expected: \"java BloomFilter 10\"");
            return;
        }


        BloomFilter<String> bloomy = new BloomFilter<>(Integer.parseInt(args[0]));
        bloomy.add("hello");
    }

    public BloomFilter(int numFilters)
    {
        this.filters = new boolean[numFilters][];

        for (int i = 0; i < numFilters; i++)
        {
            this.filters[i] = new boolean[primes[i]];
        }
    }

    public void add(T key)
    {
        int val = key.hashCode();

        if (val < 0)
        {
            val -= Integer.MIN_VALUE;
        }

        for (int i = 0; i < this.filters.length; i++)
        {
            int index = val % this.filters[i].length;
            this.filters[i][index] = true;
        }
    }
}