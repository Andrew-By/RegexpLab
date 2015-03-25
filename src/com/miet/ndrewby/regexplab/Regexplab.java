package com.miet.ndrewby.regexplab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 25.03.2015.
 */
public class Regexplab {
    public static void main(String[] args) {
        System.out.println(removeNumbers(removeNames("Hi, I'm Jack. And today we will talk about Octagon.")));
    }
    public static String removeNames(String nameString){
        return nameString.replaceAll("[^!?.] [A-Z][a-z]+", " [censored]");

    }

    public static String removeNumbers(String nameString){
        return nameString.replaceAll("^*\\d{7,12}$", "[censored]");
    }
}
