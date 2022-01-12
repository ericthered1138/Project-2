package com.shield.tests.service;

import com.shield.customexceptions.DebriefNotFound;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.daos.debrief.DebriefDAO;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;
import com.shield.services.debrief.DebriefService;
import com.shield.services.debrief.DebriefServiceImp;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;
import io.cucumber.java.BeforeAll;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shield.entities.Debrief;

import java.util.ArrayList;
import java.util.List;

public class DebriefServiceMockitoTest {

    public DebriefDAO debriefDAO;
    public DebriefService debriefService;
    public EmployeeDAO employeeDAO;
    public EmployeeService employeeService;


    @BeforeClass
    public void setup(){
        employeeDAO = Mockito.mock(EmployeeDAO.class);
        debriefDAO = Mockito.mock(DebriefDAO.class);
        debriefService = new DebriefServiceImp(debriefDAO, employeeDAO);
    }
    //Happy Tests
    @Test
    void mockGetDebriefServiceById(){
        Debrief return_debrief = new Debrief(1,1,"I am sorry for the action caused to you, I take responsibly for this.","12152021","NYC","");
        Mockito.when(debriefDAO.getDebrief(1)).thenReturn(return_debrief);
        Debrief mocked_user = debriefService.getDebriefService(1);
        Assert.assertEquals(mocked_user.getDebriefingId(), 1);
    }

    @Test
    void createDebriefServiceMock(){
        Employee created_employee = new Employee(1, 1, false, "username", "password", "Test", "Test");
        Mockito.when(employeeDAO.getEmployeeById(1)).thenReturn(created_employee);
        Debrief created_debrief = new Debrief(20,1,"My apologies, it was my fault","12302021","NYC","");
        Mockito.when(debriefDAO.createDebrief(created_debrief)).thenReturn(created_debrief);
        Debrief mocked_created_debrief = debriefService.createDebriefService(created_debrief);
        Assert.assertEquals(mocked_created_debrief.getDebriefingId(), 20);
    }
}
