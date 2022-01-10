package com.shield.tests.service;

import com.shield.customexceptions.EmployeeNotFound;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;
import io.cucumber.java.BeforeAll;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shield.entities.Employee;

public class EmployeeServiceMockitoTests {

    public EmployeeDAO employeeDAO;
    public EmployeeService employeeService;

    @BeforeClass
    public void setup(){
        employeeDAO = Mockito.mock(EmployeeDAO.class);
        employeeService = new EmployeeServiceImp(employeeDAO);
    }

    //Happy Tests
    @Test
    void getEmployeeServiceByIdMock(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Employee mocked_employee = employeeService.getEmployeeByIdService(2);
        Assert.assertEquals(mocked_employee.getUsername(), "scarlett");
    }

//    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
//    void badIdForGetUserClaimsByAgentService(){
//        employeeService.getUserClaimsByAgentService(-5);
//    }
//
//    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
//    void badIdForGetAllAgentDebriefingsService(){
//        employeeService.getAllAgentDebriefingsService(-5);
//    }
//
//    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
//    void badIdForGetAgentDebriefingsService(){
//        employeeService.getAgentDebriefingsService(-5);
//    }
}
