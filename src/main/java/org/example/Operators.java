package org.example;

import java.util.HashMap;
import java.util.Map;

public class Operators {

    public final static char ADDITION = '+';
    public final static char MULTIPLICATION = '*';
    public final static char DIVISION = '/';
    public final static char SUBTRACTION = '-';
    public final static char OPENING_BRACKET = '(';
    public final static char CLOSING_BRACKET = ')';

    private final Map<Character, Integer> precedence = new HashMap<>();

     {
        precedence.put(MULTIPLICATION, 2);
        precedence.put(DIVISION, 2);
        precedence.put(ADDITION, 1);
        precedence.put(SUBTRACTION, 1);
        precedence.put(OPENING_BRACKET, 0);
        precedence.put(CLOSING_BRACKET, 0);
    }

    public  boolean hasPrecedence(char a, char b) {
        return precedence.get(a) >= precedence.get(b);
    }

    public  boolean hasPrecedence(String a, String b) {
        return precedence.get(a.charAt(0)) >= precedence.get(b.charAt(0));
    }
}
