package com.shield.tests.service;

import com.shield.customexceptions.EmployeeNotFound;
import com.shield.customexceptions.UserNotFound;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import org.testng.annotations.Test;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;


public class EmployeeServiceTests {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    EmployeeService employeeService = new EmployeeServiceImp(employeeDAO);

<<<<<<< HEAD
    //Sad Tests
=======
>>>>>>> AlexBranch
    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAllClaims(){
        employeeService.getAllClaimsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetUserClaimsByAgentService(){
        employeeService.getUserClaimsByAgentService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAllAgentDebriefingsService(){
        employeeService.getAllAgentDebriefingsService(-5);
    }

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAgentDebriefingsService(){
        employeeService.getAgentDebriefingsService(-5);
    }
<<<<<<< HEAD

=======
>>>>>>> AlexBranch
}
