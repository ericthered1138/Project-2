package com.shield.tests.service;

import com.shield.customexceptions.EmployeeNotFound;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;
import io.cucumber.java.BeforeAll;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shield.entities.Employee;

import java.util.ArrayList;
import java.util.List;

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
    void mockGetEmployeeServiceById(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Employee mocked_employee = employeeService.getEmployeeByIdService(2);
        Assert.assertEquals(mocked_employee.getUsername(), "scarlett");
    }

    @Test
    void mockGetUserClaimsByAgentService(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Claim returned_claim = new Claim();
        returned_claim.setUserId(55);
        List<Claim> returned_list = new ArrayList<>();
        returned_list.add(returned_claim);
        Mockito.when(employeeDAO.getUserClaimsByAgent(2)).thenReturn(returned_list);
        Assert.assertNotNull(employeeService.getUserClaimsByAgentService(2));
    }

    @Test
    void mockGetAllAgentDebriefingsService(){
        Employee returned_employee = new Employee(3,0,true,"test",
                "test","test","test");
        Mockito.when(employeeDAO.getEmployeeById(3)).thenReturn(returned_employee);
        Debrief returned_debrief = new Debrief();
        returned_debrief.setEmployeeId(2);
        List<Debrief> returned_list = new ArrayList<>();
        returned_list.add(returned_debrief);
        Mockito.when(employeeDAO.getAllAgentDebriefings(3)).thenReturn(returned_list);
        Assert.assertNotNull(employeeService.getAllAgentDebriefingsService(3));
    }

    @Test
    void MockGetAgentDebriefingsService(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Debrief returned_debrief = new Debrief();
        returned_debrief.setEmployeeId(2);
        List<Debrief> returned_list = new ArrayList<>();
        returned_list.add(returned_debrief);
        Mockito.when(employeeDAO.getAllAgentDebriefings(2)).thenReturn(returned_list);
        Assert.assertNotNull(employeeService.getAgentDebriefingsService(2));
    }

    @Test
    void mockInsertEmployeeImageService(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Mockito.when(employeeDAO.insertEmployeeImage(2,"hello")).thenReturn(true);
        Assert.assertTrue(employeeDAO.insertEmployeeImage(2,"hello"));
    }

    @Test
    void mockGetEmployeeImageService(){
        Employee returned_employee = new Employee(2,3,false,"scarlett",
                "johansson","Natasha","Romanoff");
        Mockito.when(employeeDAO.getEmployeeById(2)).thenReturn(returned_employee);
        Mockito.when(employeeDAO.checkEmployeeImage(2)).thenReturn(true);
        Mockito.when(employeeDAO.getEmployeeImage(2)).thenReturn("hello");
        Assert.assertNotNull(employeeDAO.getEmployeeImage(2));
    }
}
