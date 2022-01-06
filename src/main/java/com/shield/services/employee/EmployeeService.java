package com.shield.services.employee;

import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByIdService(int employee_id);

    Employee loginEmployeeService(String username, String password);

    List<Claim> getAllClaimsService(int handler_employee_id);

    List<Claim> getUserClaimsByAgentService(int agent_employee_id);

    List<Debrief> getAllAgentDebriefingsService(int handler_employee_id);

    List<Debrief> getAgentDebriefingsService(int agent_employee_id);

    List<String> getLeaderboardService();
}
