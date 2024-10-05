package com.iquest.java.problem2.prime;

import java.util.Arrays;

public class PrimeChecker{

    private int lastValueToCheck;
    private boolean[] primeNumbers;

    public PrimeChecker(int lastValueToCheck) {
        this.lastValueToCheck = lastValueToCheck;
        this.primeNumbers = new boolean[this.lastValueToCheck + 1];
        Arrays.fill(this.primeNumbers, false);
    }

    public void performSieveOfEratosthenes()
    {
        int arraySize = this.lastValueToCheck;

        for(int index = 2; index <= arraySize; index ++) {
            this.primeNumbers[index] = true;
        }

        for (int number = 2; number * number <= arraySize; number ++) {
            if (this.primeNumbers[number]) {
                for (int index = number * number; index <= arraySize; index += number) {
                    this.primeNumbers[index] = false;
                }
            }
        }
    }

    public void displayPrimeNumbers() {
        int arraySize = this.lastValueToCheck;

        for (int index = 1; index < arraySize; index ++)
        {
            if (primeNumbers[index]) {
                System.out.print(index + "-PRIME, ");
            }else {
                System.out.print(index + ", ");
            }
        }

        if (primeNumbers[arraySize]) {
            System.out.print(arraySize + "-PRIME ");
        }else {
            System.out.print(arraySize + " ");
        }
    }
}
