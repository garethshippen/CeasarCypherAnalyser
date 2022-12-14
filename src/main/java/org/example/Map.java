package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Map
{
    //region Fields
    private final String letterFreq = "etaoinshrdlcumwfgypbvkjxqz";
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int e2t = (int)'t' - (int)'e';
    private int[] frequencies;
    private CypherPair[] cypherPairs;
    //endregion

    //region Constructor
    public Map(int[] _frequencies)
    {
        frequencies = _frequencies;
        if(!rotFilter(frequencies))
        {
            createCypherPairs();
            sortCypherPairs();
        }
    }
    //endregion

    //TODO Decypher text

    //region Methods
    private boolean rotFilter(int[] _frequencies)
    {
        /*
        returns true or false on likelihood of being a rot cypher based on distance
        between first two modal letters ie e and t or delta(et)
        */
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

    public void createCypherPairs()
    {
        int length = frequencies.length;
        CypherPair[] pairs = new CypherPair[length];
        for(int i = 0; i < length; i++)
        {
            pairs[i] = new CypherPair(alphabet.charAt(i), frequencies[i]);
        }
        cypherPairs = pairs;
    }
    public CypherPair[] sortCypherPairs()
    {
        int length = cypherPairs.length;
        //Arrays.sort(cypherPairs, Comparator.comparingInt(CypherPair::frequency));
        Arrays.sort(cypherPairs, (first, second) -> {return second.frequency() - first.frequency();});
        return cypherPairs;
    }
    public void displayCypherPairs()
    {
        int length = cypherPairs.length;
        for(int i = 0; i < length; i++)
        {
            System.out.printf("%c : %d\n", cypherPairs[i].character(), cypherPairs[i].frequency());
        }
    }
    public int getE2t()
    {
        return e2t;
    }
    //endregion
}
