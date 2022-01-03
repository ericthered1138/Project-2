package services;

import daos.EmployeeDAO;
import entities.Claim;
import entities.Debrief;
import entities.Employee;

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
        return employeeDAO.getAllClaims(handler_employee_id);
    }

    @Override
    public List<Claim> getUserClaimsByUserService(int user_id) {
        return employeeDAO.getUserClaimsByUser(user_id);
    }

    @Override
    public List<Claim> getUserClaimsByAgentService(int agent_employee_id) {
        return employeeDAO.getUserClaimsByAgent(agent_employee_id);
    }

    @Override
    public List<Debrief> getAllAgentDebriefingsService(int handler_employee_id) {
        return employeeDAO.getAllAgentDebriefings(handler_employee_id);
    }

    @Override
    public List<Debrief> getAgentDebriefingsService(int agent_employee_id) {
        return employeeDAO.getAgentDebriefings(agent_employee_id);
    }

    @Override
    public List<String> getLeaderboardService() {
        return null;
    }
}
