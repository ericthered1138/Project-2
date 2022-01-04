package tests.service;

import com.shield.customexceptions.EmployeeNotFound;
import com.shield.daos.debrief.DebriefDAO;
import com.shield.daos.debrief.DebriefDAOImp;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import com.shield.entities.Debrief;
import org.testng.annotations.Test;
import com.shield.services.debrief.DebriefService;
import com.shield.services.debrief.DebriefServiceImp;

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
