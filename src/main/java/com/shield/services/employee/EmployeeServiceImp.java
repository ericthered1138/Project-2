package com.shield.services.employee;

import com.shield.customexceptions.EmployeeIsNotAgent;
import com.shield.customexceptions.EmployeeIsNotHandler;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService{

    EmployeeDAO employeeDAO;
    public EmployeeServiceImp(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO;}

    @Override
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
            return employeeDAO.getAllClaims(handler_employee_id);
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
        //grab the list of all the claims
        //create a list to hold maps for each employee
        //total
        //monthly total
        
        return null;
    }
}
