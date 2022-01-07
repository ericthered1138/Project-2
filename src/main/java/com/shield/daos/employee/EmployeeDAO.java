package com.shield.daos.employee;

import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

import java.io.File;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employee_id);

    Employee loginEmployee(String username, String password);

    List<Claim> getAllHandlerClaims(int handler_employee_id);

    List<Claim> getUserClaimsByAgent(int agent_employee_id);

    List<Debrief> getAllAgentDebriefings(int handler_employee_id);

    List<Debrief> getAgentDebriefings(int agent_employee_id);

    List<String> getLeaderboard();

<<<<<<< HEAD

=======
    Boolean insertEmployeeImage(int employee_id, File file);

    byte[] getEmployeeImage(int employee_id);
>>>>>>> main
}
