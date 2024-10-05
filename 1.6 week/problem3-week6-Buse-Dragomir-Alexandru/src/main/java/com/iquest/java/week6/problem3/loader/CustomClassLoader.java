package com.iquest.java.week6.problem3.loader;

import com.iquest.java.week6.problem3.utility.StringUtility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CustomClassLoader extends ClassLoader{

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String fullyQualifiedName)
            throws ClassNotFoundException {
        if( ! fullyQualifiedName.contains("com.iquest.java.foreign")) {
            return super.loadClass(fullyQualifiedName);
        } else {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String simpleClassName = StringUtility.extractClassNameFromFullName(fullyQualifiedName);
                String classNameWithExtension = simpleClassName + ".class";
                String pathToFile  = classLoader.getResource(classNameWithExtension).getPath();
                String url = "file:" + pathToFile;

                URL myUrl = new URL(url);
                URLConnection connection = myUrl.openConnection();
                InputStream input = connection.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int data = input.read();

                while(data != -1) {
                    buffer.write(data);
                    data = input.read();
                }

                input.close();
                byte[] classData = buffer.toByteArray();
                return defineClass(fullyQualifiedName, classData, 0, classData.length);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
                System.err.println("Could not get the path to the .class file");
            }
            throw new ClassNotFoundException("The specified class has not been found");
        }
    }
}
