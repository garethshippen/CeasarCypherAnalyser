package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    private final static String letterFreq = "etaoinshrdlcumwfgypbvkjxqz";
    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args)
    {

    }
    private static File getFile(String _fileName) throws URISyntaxException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource(_fileName);
        if(resource == null)
        {
            throw new IllegalArgumentException("File not found. " + _fileName);
        }
        else
        {
            return new File(resource.toURI());
        }
    }
    private static int[] getTextFreq(File _file)
    {
        BufferedReader bufferedReader;
        int[] frequencies = new int[26];
        try
        {
            bufferedReader = new BufferedReader(new FileReader(_file));
            int red;
            char character;
            while((red = bufferedReader.read()) != -1)
            {
                character = Character.toLowerCase((char) red);
                red = (int)character;
                //a = 97
                //z = 122
                if(red > 96 && red < 123) {
                    int index = letterFreq.indexOf(character);
                    frequencies[index]++;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return frequencies;
    }
}