package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationValidator {

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        return pattern.matcher(strNum).matches();
    }

    public List<String> formatEquation(String equation){
        Pattern p = Pattern.compile("-?\\d*\\.?\\d+|[+\\-*/()]");
        Matcher m = p.matcher(equation);
        List<String> result = new ArrayList<>();

        while(m.find()){
            result.add(m.group());
        }

        return result;
    }

}
