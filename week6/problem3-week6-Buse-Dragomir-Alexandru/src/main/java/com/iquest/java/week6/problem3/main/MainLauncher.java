package com.iquest.java.week6.problem3.main;

import com.iquest.java.week6.problem3.factory.ClassLoaderFactory;

public class MainLauncher {

    public static void main(String[] args) {

        // some basic instantiation tests for the method that returns a Class object
        String fullyQualifiedNameInternal = "com.iquest.java.week6.problem3.pojo.MyClass";
        String fullyQualifiedNameExternal = "com.iquest.java.foreign.MyClass";
        String fullyQualifiedNameExternalSubclass = "com.iquest.java.foreign.MySubclass";

        try {
            Class myClassExternal = ClassLoaderFactory.getClass(fullyQualifiedNameExternal);
            Class mySubclass = ClassLoaderFactory.getClass(fullyQualifiedNameExternalSubclass);
            Class myClassInternal = ClassLoaderFactory.getClass(fullyQualifiedNameInternal);
            try {
                System.out.println(myClassExternal.newInstance());
                System.out.println(mySubclass.newInstance());
                System.out.println(myClassInternal.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        };
    }
}
