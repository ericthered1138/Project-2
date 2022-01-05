package com.shield.daos.employee;

import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployeeById(int employee_id);

    Employee loginEmployee(String username, String password);

    List<Claim> getAllClaims(int handler_employee_id);

    List<Claim> getUserClaimsByUser(int user_id);

    List<Claim> getUserClaimsByAgent(int agent_employee_id);

    List<Debrief> getAllAgentDebriefings(int handler_employee_id);

    List<Debrief> getAgentDebriefings(int agent_employee_id);

    List<String> getLeaderboard();
}
