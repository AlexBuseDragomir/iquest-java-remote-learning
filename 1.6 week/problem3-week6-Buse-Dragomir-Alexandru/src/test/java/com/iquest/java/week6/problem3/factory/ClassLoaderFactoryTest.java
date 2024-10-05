package com.iquest.java.week6.problem3.factory;

import com.iquest.java.week6.problem3.pojo.MyClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ClassLoaderFactoryTest {

    private String fullyQualifiedNameInternal;
    private String fullyQualifiedNameExternal;
    private String fullyQualifiedNameExternalSubclass;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.fullyQualifiedNameInternal = "com.iquest.java.week6.problem3.pojo.MyClass";
        this.fullyQualifiedNameExternal = "com.iquest.java.foreign.MyClass";
        this.fullyQualifiedNameExternalSubclass = "com.iquest.java.foreign.MySubclass";
    }

    @Test
    public void testInstanceOfInternalClass() {
        //WHEN
        Object internalMyClass = null;
        try {
            internalMyClass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameInternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert internalMyClass != null;
        assertThat(internalMyClass.toString(), is("MyClass from project"));
    }

    @Test
    public void testInstanceOfExternalClass() {
        //WHEN
        Object externalMyClass = null;
        try {
            externalMyClass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameExternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert externalMyClass != null;
        assertThat(externalMyClass.toString(), is("MyClass from resources"));
    }

    @Test
    public void testSignatureForInternalClass() {
        //WHEN
        Object internalMyClass = null;
        try {
            internalMyClass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameInternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert internalMyClass != null;
        assertThat(internalMyClass.getClass().getCanonicalName(),
                is("com.iquest.java.week6.problem3.pojo.MyClass"));
    }

    @Test
    public void testSignatureForExternalClass() {
        //WHEN
        Object externalMyClass = null;
        try {
            externalMyClass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameExternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert externalMyClass != null;
        assertThat(externalMyClass.getClass().getCanonicalName(),
                is("com.iquest.java.foreign.MyClass"));
    }

    @Test
    public void testSignatureForExternalSubclass() {
        //WHEN
        Object externalMySubclass = null;
        try {
            externalMySubclass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameExternalSubclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert externalMySubclass != null;
        assertThat(externalMySubclass.getClass().getCanonicalName(),
                is("com.iquest.java.foreign.MySubclass"));
    }

    @Test
    public void testCastFromExternalToInternal() {
        exception.expect(ClassCastException.class);
        Object externalMyClass = null;
        try {
            externalMyClass = ClassLoaderFactory.getClassInstance(fullyQualifiedNameExternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MyClass myClass = (MyClass)externalMyClass;
    }

    @Test
    public void testInternalClass() {
        //WHEN
        Class internalMyClass = null;
        try {
            internalMyClass = ClassLoaderFactory.getClass(fullyQualifiedNameInternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert internalMyClass != null;
        assertThat(internalMyClass.getCanonicalName(), is("com.iquest.java.week6.problem3.pojo.MyClass"));
    }

    @Test
    public void testExternalClass() {
        //WHEN
        Class externalMyClass = null;
        try {
            externalMyClass = ClassLoaderFactory.getClass(fullyQualifiedNameExternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert externalMyClass != null;
        assertThat(externalMyClass.getCanonicalName(), is("com.iquest.java.foreign.MyClass"));
    }

    @Test
    public void testExternalSubclass() {
        //WHEN
        Class externalMySubclass = null;
        try {
            externalMySubclass = ClassLoaderFactory.getClass(fullyQualifiedNameExternalSubclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //THEN
        assert externalMySubclass != null;
        assertThat(externalMySubclass.getCanonicalName(), is("com.iquest.java.foreign.MySubclass"));
    }

    @Test
    public void testCastFromExternalToInternalClass() {
        exception.expect(ClassCastException.class);
        Class externalMyClass = null;
        try {
            externalMyClass = ClassLoaderFactory.getClass(fullyQualifiedNameExternal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert externalMyClass != null;
            MyClass myClass = (MyClass)externalMyClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
