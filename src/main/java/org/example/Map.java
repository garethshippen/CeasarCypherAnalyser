package org.example;

public class Map
{
    private final String letterFreq = "etaoinshrdlcumwfgypbvkjxqz";
    public final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int[] frequencies;
    private static final int e2t = (int)'t' - (int)'e';
    public Map(int[] _frequencies)
    {
        frequencies = _frequencies;
    }

    public static int e2Tdist(int[] _frequencies) //the distance between first and second modal letter
    {
        int[] frequencies = _frequencies;
        final int REPEATS = 2;
        int instances;
        //int index = -1;
        int[] modals = new int[REPEATS];
        int length = frequencies.length;

        for(int j = 0; j < REPEATS; j++) {
            instances = 0;
            modals[j] = -1;
            for (int i = 0; i < length; i++)
            {
                if (frequencies[i] > instances)
                {
                    instances = frequencies[i];
                    //index = i;
                    modals[j] = i;
                }
            }

            frequencies[modals[j]] = -1;
        }
        System.out.printf("\'e\' is %d \'t\' is %d\n", modals[0], modals[1]);
        if(modals[0] >= 0 && modals[1] >= 0)
        {
            return (length + modals[1] - modals[0]) % length;
        }
        else
        {
            return -1;
        }
    }
    public static int getE2t(){return e2t;}
}
