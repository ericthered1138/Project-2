package tests.service;

import customexceptions.EmployeeNotFound;
import customexceptions.UserNotFound;
import daos.EmployeeDAO;
import daos.EmployeeDAOImp;
import org.testng.annotations.Test;
import services.EmployeeService;
import services.EmployeeServiceImp;


public class EmployeeServiceTests {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    EmployeeService employeeService = new EmployeeServiceImp(employeeDAO);

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForGetAllClaims(){
        employeeService.getAllClaimsService(-5);
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "The user was not found.")
    void badIdForGetUserClaimsByUserService(){
        employeeService.getUserClaimsByUserService(-5);
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
}
