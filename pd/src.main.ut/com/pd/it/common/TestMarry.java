package com.pd.it.common;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestMarry
{
    public final static int number = 100;
    
    public final static int loop = 100000;
    
    private static Set<Integer> woman;
    
    private static int[] manRs;
    
    private static int[] womanRs;
    
    public static void main(String[] args)
    {
        initRs();
        for (int i = 0; i < loop; i++)
        {
            initSrc();
            match();
        }
        showSingle();
    }
    
    private static void initSrc()
    {
        woman = new HashSet<Integer>();
        for (int i = 0; i < number; i++)
        {
            woman.add(i);
        }
    }
    
    private static void initRs()
    {
        manRs = new int[number];
        womanRs = new int[number];
        for (int i = 0; i < number; i++)
        {
            manRs[i] = 0;
            womanRs[i] = 0;
        }
    }
    
    public static List<Integer> init(int number)
    {
        List<Integer> rs = new ArrayList<Integer>();
        for (int i = 0; i < number; i++)
        {
            rs.add(i);
        }
        return rs;
    }
    
    private static void showSingle()
    {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("value\tman\twoman\n");
        for (int i = 0; i < manRs.length; i++)
        {
            String str = String.format("%d\t%d\t%d\n", i, manRs[i],womanRs[i]);
            sBuffer.append(str);
        }
        System.out.println(sBuffer);
    }
    
    private static void match()
    {
        Random random = new Random();
        for (int i = number - 1; i > 0; i--)
        {
            //System.out.println("\nmanIndex:" + i);
            List<Integer> validWoman = getValidWoman(i, woman);
            if (validWoman.size() > 0)
            {
                int randomIndex = random.nextInt(validWoman.size());
                //System.out.println("randomIndex:" + randomIndex);
                int validWomanIndex = validWoman.get(randomIndex);
                //System.out.println("validWomanIndex:" + validWomanIndex);
                woman.remove(validWomanIndex);
                womanRs[validWomanIndex]++;
                manRs[i]++;
            }
        }
    }
    
    private static List<Integer> getValidWoman(int valueMan, Set<Integer> woman)
    {
        List<Integer> rs = new ArrayList<Integer>();
        for (int eachWoman : woman)
        {
            if (eachWoman < valueMan * 0.5 || eachWoman*1.8 > valueMan)
            {
                continue;
            }
            rs.add(eachWoman);
        }
        return rs;
    }
    
}
