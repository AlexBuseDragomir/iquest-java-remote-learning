package com.iquest.java.problem1.factory;

import com.iquest.java.problem1.domain.Employee;
import com.iquest.java.problem1.domain.Engine;
import com.iquest.java.problem1.domain.EngineArchitecture;
import com.iquest.java.problem1.domain.EngineComponent;
import com.iquest.java.problem1.exception.InsufficientStockException;
import com.iquest.java.problem1.exception.UnauthorizedEmployeeException;
import com.iquest.java.problem1.exception.UnqualifiedEmployeeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EngineFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualified() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedNullComponents() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee), null);
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedNegativeNumberOfEngines() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(Integer.MIN_VALUE, employee);
    }

    @Test
    public void testEmployeeNotQualifiedNotAdministratorNotWorker() {
        exception.expect(UnqualifiedEmployeeException.class);
        exception.expectMessage("Employee [Jake] is not qualified to build engines");
        Employee employee = new Employee("Jake", false, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = UnauthorizedEmployeeException.class)
    public void testEmployeeNotAuthorized() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = UnauthorizedEmployeeException.class)
    public void testEmployeeNotAuthorizedNullComponents() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(), null);
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = UnauthorizedEmployeeException.class)
    public void testEmployeeNotAuthorizedNegativeNumberOfEngines() {
        Employee employee = new Employee("Jake", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(Integer.MIN_VALUE, employee);
    }

    @Test
    public void testEmployeeNotAuthorizedWithErrorMessage() {
        exception.expect(UnauthorizedEmployeeException.class);
        exception.expectMessage("Employee [Jake] is not authorized to work at this factory!");
        Employee employee = new Employee("Jake", true, false);
        Employee anotherEmployee = new Employee("Michael", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(anotherEmployee), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(2, employee);
    }

    @Test
    public void testEmployeeNotAuthorizedNotAdministratorNotWorker() {
        exception.expect(UnauthorizedEmployeeException.class);
        exception.expectMessage("Employee [Jake] is not authorized to work at this factory!");
        Employee employee = new Employee("Jake", false, false);
        Employee anotherEmployee = new Employee("Michael", true, false);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(anotherEmployee), new ArrayList<EngineComponent>());
        engineFactory.manufactureEngines(2, employee);
    }

    @Test(expected = InsufficientStockException.class)
    public void testInsufficientStock() {
        Employee employee = new Employee("Jake", false, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee),
                new ArrayList<EngineComponent>(Collections.nCopies(2, new EngineComponent("ec1", 10))));
        engineFactory.manufactureEngines(1, employee);
    }

    @Test
    public void testInsufficientStockSecond() {
        exception.expect(InsufficientStockException.class);
        exception.expectMessage("Not enough stock to build [3] engines");
        Employee employee = new Employee("Jake", false, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee),
                new ArrayList<EngineComponent>(Collections.nCopies(8, new EngineComponent("ec1", 10))));
        engineFactory.manufactureEngines(3, employee);
    }

    @Test
    public void testInsufficientStockNullComponents() {
        exception.expect(InsufficientStockException.class);
        exception.expectMessage("Not enough stock to build [3] engines");
        Employee employee = new Employee("Jake", false, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee), null);
        engineFactory.manufactureEngines(3, employee);
    }

    @Test
    public void testSufficientStock() {
        Employee employee = new Employee("Jake", false, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee),
                new ArrayList<EngineComponent>(Collections.nCopies(10, new EngineComponent("ec1", 10))));
        List<Engine> engines = engineFactory.manufactureEngines(2, employee);
        Assert.assertNotNull(engines);
        Assert.assertEquals(2, engines.size());
    }

    @Test
    public void testSufficientStockAdministratorAndWorker() {
        Employee employee = new Employee("Jake", true, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee),
                new ArrayList<EngineComponent>(Collections.nCopies(10, new EngineComponent("ec1", 10))));
        List<Engine> engines = engineFactory.manufactureEngines(2, employee);
        Assert.assertNotNull(engines);
        Assert.assertEquals(2, engines.size());
    }

    @Test
    public void testSufficientStockEngineDetails() {
        Employee employee = new Employee("Jake", false, true);
        EngineFactory engineFactory = new EngineFactory(Arrays.asList(employee),
                new ArrayList<EngineComponent>(Collections.nCopies(10, new EngineComponent("ec1", 10))));
        List<Engine> engines = engineFactory.manufactureEngines(2, employee);
        Assert.assertNotNull(engines);
        Assert.assertEquals(2, engines.size());
        assertThat(engines.get(0).getHorsePower(), is(210));
        assertThat(engines.get(0).getDisplacement(), is(2.0));
        assertThat(engines.get(0).getEngineArchitecture(), is(EngineArchitecture.L4));
    }
}
