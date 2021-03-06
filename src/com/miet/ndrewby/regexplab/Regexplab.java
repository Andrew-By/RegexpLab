package com.miet.ndrewby.regexplab;

import java.math.MathContext;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 25.03.2015.
 */
public class Regexplab {
    private static ArrayList<String> names = new ArrayList<String>();

    public static void main(String[] args) {

        System.out.println(removeNamesStage2(removeNumbers(removeNamesStage1(
                "Hi, I'm Wheeler (Andrew)! And today we will talk about Octagon. BTW my phone number is 89261940493!. Wheeler is nickname for truckers."))));
        System.out.println("Names found:");
        for(String name : names){
            System.out.println(name);
        }
    }
    public static String removeNamesStage1(String nameString){
        String out = "";
        Integer lastEnd = 0;
        Pattern p = Pattern.compile("[^!?.\\s]\\s?[A-Z][a-z]+");
        Matcher m = p.matcher(nameString);
        while(m.find()){
            out+=nameString.substring(lastEnd, m.start()+1)+ "[censored]";
            names.add(nameString.substring(m.start()+1, m.end()).trim());
            lastEnd = m.end();
        }
        out+=nameString.substring(lastEnd);
        return out;

    }

    public static String removeNamesStage2(String nameString){
        for(String name : names){
            nameString = nameString.replace(name, "[censored]");
        }
        return  nameString;
    }

    public static String removeNumbers(String nameString){
        return nameString.replaceAll("\\d{7,12}", "[censored]");
    }
}
