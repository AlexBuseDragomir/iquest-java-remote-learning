package main;

import application.EventApplication;
import application.SimpleEventApplication;

public class MainLauncher {

    public static void main(String[] args) {

        EventApplication eventApplication = new SimpleEventApplication();
        eventApplication.run();
    }
}
