package org.example;

import java.util.HashMap;
import java.util.Map;

public class Precedence {

    private final Map<String, Integer> precedence = new HashMap<>();

     {
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("(", 0);
        precedence.put(")", 0);
    }

    public  boolean hasPrecedence(String a, String b) {
        return precedence.get(a) >= precedence.get(b);
    }
}
