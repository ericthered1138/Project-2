package tests.dao;

import daos.EmployeeDAO;
import daos.EmployeeDAOImp;
import entities.Employee;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Util.DatabaseTableCreator.table_depopulator;
import static Util.DatabaseTableCreator.table_populator;

public class EmployeeDAOTests {

    EmployeeDAO employeeDAO = new EmployeeDAOImp();

    @BeforeClass
    void setup(){
        table_depopulator();
        table_populator();
    };

    @AfterClass
    void teardown(){
        table_depopulator();
    };

    @Test
    void getEmployeeById() {
        Employee employee = employeeDAO.getEmployeeById(1_000_001);
        System.out.println(employee);
        Assert.assertEquals(employee.getEmployeeId(),1_000_001);
    }
}
