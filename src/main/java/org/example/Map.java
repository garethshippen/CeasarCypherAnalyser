package org.example;

public class Map
{
    private final String letterFreq = "etaoinshrdlcumwfgypbvkjxqz";
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int e2t = (int)'t' - (int)'e';
    private int[] frequencies;
    public Map(int[] _frequencies)
    {
        frequencies = _frequencies;
    }

    /*
    returns true or false on likelihood of being a rot cypher based on distance
    between first two modal letters ie e and t or delta(et)
    */
    private boolean rotFilter(int[] _frequencies)
    {
        boolean isRot = false;
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

        if(modals[0] >= 0 && modals[1] >= 0) //has meaningful values for 'e' and 't'
            if(((length + modals[1] - modals[0]) % length) == e2t) //compare delta('e''t') with delta(et)
                isRot = true;

        return isRot;
    }
    public int getE2t(){return e2t;}
}
