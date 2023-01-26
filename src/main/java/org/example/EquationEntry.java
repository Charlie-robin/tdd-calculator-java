package org.example;

import java.util.Date;

public class EquationEntry {
    private int id;
    private String equation;
    private double result;
    private String date = new Date().toString();


    public EquationEntry() {
    }

    public EquationEntry(int id, String equation, double result) {
        this.id = id;
        this.equation = equation;
        this.result = result;
    }

    public EquationEntry(int id, String equation, double result, String date) {
        this.id = id;
        this.equation = equation;
        this.result = result;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
