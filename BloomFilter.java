// BloomFilter by John Connerton 

import java.util.*;

public class BloomFilter.<T>
{
    private boolean[][] filters;
    public int[] primes = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43};

    public void add(T key)
    {
        int val = key.hashCode();

        for (int i = 0; i < filters.length; i++)
        {
            int index = val % filters[i].length;
            filters[i][index];
        }

    }

    public static void main(String[] args)
    {
        if (args.length < 1) 
        {
            System.out.println("Format expected: \"java BloomFilter 10\"");
            return;
        }


        BloomFilter bloomy = new BloomFilter(Integer.parseInt(args[0]));
        System.out.println("hello".hashCode());
    }

    public BloomFilter(int numFilters)
    {
        this.filters = new boolean[amountOfFilters][];

        for (int i = 0; i < amountOfFilters; i++)
        {
            this.filters[i] = new boolean[primes[i]];
        }
    }
}