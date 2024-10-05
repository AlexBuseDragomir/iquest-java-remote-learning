package com.iquest.java.problem2.factory;

import com.iquest.java.problem2.exception.InvalidClassInputException;

import java.lang.reflect.Proxy;

public class CustomProxyFactory {

    public static Object getNewCustomProxyInstance(Class<?> interfaceClass, Class<?> implementationClass)
            throws InvalidClassInputException, InstantiationException, IllegalAccessException {
        if (interfaceClass.isInterface()) {
            if (interfaceClass.isAssignableFrom(implementationClass)) {
                return Proxy.newProxyInstance(
                        interfaceClass.getClassLoader(),
                        new Class[]{ interfaceClass },
                        new CustomInvocationHandler(implementationClass.newInstance()));
            } else {
                throw new InvalidClassInputException(implementationClass.getSimpleName() +
                        " does not implement " + interfaceClass.getSimpleName());
            }
        } else {
            throw new InvalidClassInputException(interfaceClass.getSimpleName() + " is not an interface");
        }
    }
}
