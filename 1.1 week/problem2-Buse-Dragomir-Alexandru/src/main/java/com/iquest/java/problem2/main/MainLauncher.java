package com.iquest.java.problem2.main;

import com.iquest.java.problem2.prime.PrimeChecker;

public class MainLauncher {

    public static void main(String[] args) {

        PrimeChecker primeChecker = new PrimeChecker(Integer.parseInt(args[0]));
        primeChecker.performSieveOfEratosthenes();
        primeChecker.displayPrimeNumbers();
    }
}
