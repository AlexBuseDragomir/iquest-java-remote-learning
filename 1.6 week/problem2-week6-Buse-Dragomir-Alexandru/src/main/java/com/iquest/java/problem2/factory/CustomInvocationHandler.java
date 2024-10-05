package com.iquest.java.problem2.factory;

import com.iquest.java.problem2.annotation.Logged;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private Object proxied;

    public CustomInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Class proxiedClass = this.proxied.getClass();

        if (proxiedClass.getAnnotation(Logged.class) != null) {
            System.out.println("The class " + proxiedClass.getSimpleName() +
                    " is annotated with @Logged");
            System.out.println("Canonical class name: " +
                    proxiedClass.getCanonicalName());
        } else {
            System.out.println("The class " + proxiedClass.getSimpleName() +
                    " is not annotated with @Logged");
        }

        for (Method classMethod: proxiedClass.getDeclaredMethods()) {
            if (classMethod.isAnnotationPresent(Logged.class)) {
                System.out.println("\n@Logged present on " + classMethod);
            }
        }

        if (method.getAnnotation(Logged.class) != null) {
            System.out.println("\nThe invoked method: " + method.getName() +
                    "(...) is annotated with the Logged annotation in the interface");
            System.out.println("Signature: " + method);
        } else {
            System.out.println("The invoked method is not annotated in the interface");
        }
        // delegation
        System.out.println();
        return method.invoke(proxied, args);
    }
}
