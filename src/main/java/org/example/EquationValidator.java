package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationValidator {

    static final String IS_NUMBER = "-?\\d+(\\.\\d+)?";
    static final String IS_NUMBER_OR_OPERATOR = "-?\\d*\\.?\\d+|[+\\-*/()]";

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile(IS_NUMBER);
        return pattern.matcher(strNum).matches();
    }

    public List<String> formatEquation(String equation){
        Pattern pattern = Pattern.compile(IS_NUMBER_OR_OPERATOR);
        Matcher matcher = pattern.matcher(equation);
        List<String> result = new ArrayList<>();

        while(matcher.find()){
            result.add(matcher.group());
        }

        return result;
    }

}
