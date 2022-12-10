package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    private final static char[] letterFreq = {'e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'};
    private final static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
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
    private static void readLetters(File _file)
    {
        BufferedReader bufferedReader;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(_file));
            int red;
            char character;
            while((red = bufferedReader.read()) != -1)
            {
                character = (char) red;


            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}