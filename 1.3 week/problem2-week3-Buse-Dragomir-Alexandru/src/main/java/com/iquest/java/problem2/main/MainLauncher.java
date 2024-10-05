package com.iquest.java.problem2.main;

import com.iquest.java.problem2.amphibians.Amphibian;
import com.iquest.java.problem2.amphibians.Frog;

@SuppressWarnings("UnnecessaryLocalVariable")
public class MainLauncher {

    public static void main(String[] args) {

        Amphibian frog = new Frog(15, "tropical forests",
                "neotropical", "Agalychnis callidryas");
        // upcast
        Amphibian amphibian = (Amphibian)frog;
        System.out.println(amphibian);
        amphibian.moveForward(30);
        amphibian.eatSomething("millipede");
        // downcast
        ((Frog)amphibian).makeASound("ribbit");
    }
}
