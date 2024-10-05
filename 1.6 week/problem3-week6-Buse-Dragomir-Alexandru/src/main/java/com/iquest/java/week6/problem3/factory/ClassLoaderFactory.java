package com.iquest.java.week6.problem3.factory;

import com.iquest.java.week6.problem3.loader.CustomClassLoader;

public class ClassLoaderFactory<T> {

    public static Object getClassInstance(String fullyQualifiedName)
            throws ClassNotFoundException {
        ClassLoader parentClassLoader = CustomClassLoader.class.getClassLoader();
        CustomClassLoader customClassLoader = new CustomClassLoader(parentClassLoader);
        try {
            Class classObject = customClassLoader.loadClass(fullyQualifiedName);
            try {
                return classObject.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException("The class " + fullyQualifiedName +
                " has not been found");
    }

    public static Class getClass(String fullyQualifiedName)
            throws ClassNotFoundException {
        ClassLoader parentClassLoader = CustomClassLoader.class.getClassLoader();
        CustomClassLoader customClassLoader = new CustomClassLoader(parentClassLoader);
        return customClassLoader.loadClass(fullyQualifiedName);
    }
}
