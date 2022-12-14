package org.example;

public class Map
{
    private final String letterFreq = "etaoinshrdlcumwfgypbvkjxqz";
    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int[] frequencies;
    public static int e2t = (alphabet.length() + alphabet.indexOf('e') - alphabet.indexOf('t')) % alphabet.length();

    public Map(int[] _frequencies)
    {
        frequencies = _frequencies;
    }

    public static int e2Tdist(int[] _frequencies) //the distance between first and second modal letter
    {
        int[] frequencies = _frequencies;
        final int REPEATS = 2;
        int instances;
        int[] index = new int[REPEATS];
        int length = frequencies.length;

        for(int j = 0; j < REPEATS; j++) {
            instances = 0;
            index[j] = -1;
            for (int i = 0; i < length; i++) {
                if (frequencies[i] > instances)
                    index[j] = i;
                    frequencies[i] = -1;
            }
        }
//        if(index[0] >= 0 && index[1] >= 0)
//        {
//            return (length + index[0] - index[1]) % length;
//        }
//        else
//        {
//            return -1;
//        }
        return (length + index[0] - index[1]) % length;
    }
    public int getE2t(){return e2t;}
}
