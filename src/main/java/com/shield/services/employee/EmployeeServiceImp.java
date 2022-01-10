package com.shield.services.employee;

import com.shield.customexceptions.EmployeeIsNotAgent;
import com.shield.customexceptions.EmployeeIsNotHandler;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> AlexBranch
import java.util.List;

public class EmployeeServiceImp implements EmployeeService{

    EmployeeDAO employeeDAO;
    public EmployeeServiceImp(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO;}

    @Override
<<<<<<< HEAD
    public List<Employee> getAllEmployeesService() {
        return employeeDAO.getAllEmployees();
    }

    @Override
=======
>>>>>>> AlexBranch
    public Employee getEmployeeByIdService(int employee_id) {
        return employeeDAO.getEmployeeById(employee_id);
    }

    @Override
    public Employee loginEmployeeService(String username, String password) {
        return employeeDAO.loginEmployee(username, password);
    }

    @Override
    public List<Claim> getAllClaimsService(int handler_employee_id) {
        //Check if the employee exists by id.
        Employee employee = employeeDAO.getEmployeeById(handler_employee_id);

        //Check if the employee is a handler.
        if (employee.isHandler()){
<<<<<<< HEAD
            return employeeDAO.getAllHandlerClaims(handler_employee_id);
=======
            return employeeDAO.getAllClaims(handler_employee_id);
>>>>>>> AlexBranch
        }else{
            throw new EmployeeIsNotHandler("That employee is not a handler.");
        }

    }


    @Override
    public List<Claim> getUserClaimsByAgentService(int agent_employee_id) {
        //Check if the agent exists.
        Employee employee = employeeDAO.getEmployeeById(agent_employee_id);

        //Check to make sure the employee is not a handler.
        if (!employee.isHandler()){
            return employeeDAO.getUserClaimsByAgent(agent_employee_id);
        }else{
            throw new EmployeeIsNotAgent("That employee is not an agent.");
        }
    }

    @Override
    public List<Debrief> getAllAgentDebriefingsService(int handler_employee_id) {
        //Check if the employee exists by id.
        Employee employee = employeeDAO.getEmployeeById(handler_employee_id);

        //Check if the employee is a handler.
        if (employee.isHandler()){
            return employeeDAO.getAllAgentDebriefings(handler_employee_id);
        }else{
            throw new EmployeeIsNotHandler("That employee is not a handler.");
        }
    }

    @Override
    public List<Debrief> getAgentDebriefingsService(int agent_employee_id) {
        //Check if the agent exists.
        Employee employee = employeeDAO.getEmployeeById(agent_employee_id);

        //Check to make sure the employee is not a handler.
        if (!employee.isHandler()){
            return employeeDAO.getAgentDebriefings(agent_employee_id);
        }else{
            throw new EmployeeIsNotAgent("That employee is not an agent.");
        }
    }

    @Override
    public List<String> getLeaderboardService() {
<<<<<<< HEAD
        return employeeDAO.getLeaderboard();
    }

    @Override
    public Boolean insertEmployeeImageService(int employee_id, File file) {
        return employeeDAO.insertEmployeeImage(employee_id, file);
    }

    @Override
    public String getEmployeeImageService(int employee_id) {
        return employeeDAO.getEmployeeImage(employee_id);
=======
        return null;
>>>>>>> AlexBranch
    }
}
