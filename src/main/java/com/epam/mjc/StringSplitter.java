package com.epam.mjc;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String[] str ;
        List<String> list;
        String s1 = "";
        for(String s:delimiters) {
            s1=s1+s;
        }
        String s = "[".concat(s1).concat( "]");
        str = source.split(s);
        list = Arrays.asList(str);
        return list;
        //throw new UnsupportedOperationException("You should implement this method.");
    }
}
