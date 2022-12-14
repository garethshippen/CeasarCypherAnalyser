package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws URISyntaxException
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
    } //returns input stream from a file
    private static int[] getTextFreq(File _file) //returns int array of instances of letter a, letter b...
    {
        BufferedReader bufferedReader;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] frequencies = new int[26];
        int index;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(_file));
            int red;
            char character;
            while((red = bufferedReader.read()) != -1)
            {
                character = Character.toLowerCase((char) red);
                //System.out.println(character);
                red = (int)character;
                //a = 97
                //z = 122
                if(red > 96 && red < 123) {
                    index = alphabet.indexOf(character);
                    frequencies[index]++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return frequencies;
    }
}