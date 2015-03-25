package com.miet.ndrewby.regexplab;

import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 25.03.2015.
 */
public class Regexplab {
    public static void main(String[] args) {
        System.out.println(removeNumbers(removeNames("Hi, I'm Jack! And today we will talk about Octagon.")));
    }
    public static String removeNames(String nameString){
        String out = "";
        Integer lastEnd = 0;
        Pattern p = Pattern.compile("[^!?.] [A-Z][a-z]+");
        Matcher m = p.matcher(nameString);
        while(m.find()){
            out+=nameString.substring(lastEnd, m.start()+1)+ " [censored]";
            lastEnd = m.end();
        }
        return out;

    }

    public static String removeNumbers(String nameString){
        return nameString.replaceAll("^*\\d{7,12}$", "[censored]");
    }
}
