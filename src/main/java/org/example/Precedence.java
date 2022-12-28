package org.example;

import java.util.HashMap;
import java.util.Map;

public class Precedence {

    private static final Map<String, Integer> precedence = new HashMap<>();

    static {
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("(", 0);
        precedence.put(")", 0);
    }

    public static boolean hasPrecedence(String a, String b) {
        return precedence.get(a) >= precedence.get(b);
    }
}
