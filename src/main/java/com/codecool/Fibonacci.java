package com.codecool;

import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {
    private Integer firstNumber = 0;
    private Integer secondNumber = 1;

    @Override
    public Integer get() {
        Integer nextNumber = firstNumber + secondNumber;
        firstNumber = secondNumber;
        secondNumber = nextNumber;
        return nextNumber;
    }
}
