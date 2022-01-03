package tests.service;

import customexceptions.EmployeeNotFound;
import daos.DebriefDAO;
import daos.DebriefDAOImp;
import daos.EmployeeDAO;
import daos.EmployeeDAOImp;
import entities.Debrief;
import org.testng.annotations.Test;
import services.DebriefService;
import services.DebriefServiceImp;

public class DebriefServiceTests {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    DebriefDAO debriefDao = new DebriefDAOImp();
    DebriefService debriefService = new DebriefServiceImp(debriefDao, employeeDAO);

    @Test(expectedExceptions = EmployeeNotFound.class, expectedExceptionsMessageRegExp = "The employee was not found.")
    void badIdForcreateDebriefService(){
        Debrief testDebrief = new Debrief();
        testDebrief.setEmployeeId(-5);
        debriefService.createDebriefService(testDebrief);
    }

}
