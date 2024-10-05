package com.iquest.java.problem2.factory;

import com.iquest.java.problem2.domain.Employee;
import com.iquest.java.problem2.domain.Engine;
import com.iquest.java.problem2.domain.EngineArchitecture;
import com.iquest.java.problem2.exception.UnqualifiedEmployeeException;
import com.iquest.java.problem2.service.EmployeeService;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EngineFactoryTest {

    private EngineFactory engineFactory;
    private EmployeeService employeeService;

    @Before
    public void setupMock() {
        employeeService = EasyMock.createMock(EmployeeService.class);
        engineFactory = new EngineFactory(employeeService);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualified() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(false);
        EasyMock.replay(employeeService);

        engineFactory.manufactureEngines(2, employee);

        EasyMock.verify(employeeService);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedZeroEngines() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(false);
        EasyMock.replay(employeeService);

        engineFactory.manufactureEngines(0, employee);

        EasyMock.verify(employeeService);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedNegativeNumberOfEngines() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(false);
        EasyMock.replay(employeeService);

        engineFactory.manufactureEngines(Integer.MIN_VALUE, employee);

        EasyMock.verify(employeeService);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedAdministratorNotWorker() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAdministrator(employee)).andReturn(true);
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(false);
        EasyMock.replay(employeeService);

        engineFactory.manufactureEngines(2, employee);

        EasyMock.verify(employeeService);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testEmployeeNotQualifiedNotAdministratorNotWorker() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAdministrator(employee)).andReturn(false);
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(false);
        EasyMock.replay(employeeService);

        engineFactory.manufactureEngines(2, employee);

        EasyMock.verify(employeeService);
    }

    @Test
    public void testEmployeeQualified() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(true);
        EasyMock.replay(employeeService);

        List<Engine> engines = engineFactory.manufactureEngines(2, employee);

        EasyMock.verify(employeeService);
        Assert.assertNotNull(engines);
        Assert.assertEquals(2, engines.size());
    }

    @Test
    public void testEmployeeQualifiedZeroEngines() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(true);
        EasyMock.replay(employeeService);

        List<Engine> engines = engineFactory.manufactureEngines(0, employee);

        EasyMock.verify(employeeService);
        Assert.assertNotNull(engines);
        assertThat(engines.size(), is(0));
    }

    @Test
    public void testEmployeeQualifiedNegativeNumberOfEngines() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(true);
        EasyMock.replay(employeeService);

        List<Engine> engines = engineFactory.manufactureEngines(Integer.MIN_VALUE, employee);

        EasyMock.verify(employeeService);
        Assert.assertNotNull(engines);
        assertThat(engines.size(), is(0));
    }

    @Test
    public void testEmployeeQualifiedAndCorrectEngineData() {
        Employee employee = new Employee("Jack");
        EasyMock.expect(employeeService.isAssemblyLineWorker(employee)).andReturn(true);
        EasyMock.replay(employeeService);

        List<Engine> engines = engineFactory.manufactureEngines(100, employee);

        EasyMock.verify(employeeService);
        Assert.assertNotNull(engines);
        assertThat(engines.size(), is(100));
        for (Engine engine: engines) {
            assertThat(engine.getDisplacement(), is(2.0));
            assertThat(engine.getHorsePower(), is(210));
            assertThat(engine.getEngineArchitecture(), is(EngineArchitecture.L4));
        }
    }
}