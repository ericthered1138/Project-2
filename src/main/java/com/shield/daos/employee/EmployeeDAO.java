package com.shield.daos.employee;

import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> AlexBranch
import java.util.List;

public interface EmployeeDAO {

<<<<<<< HEAD
    List<Employee> getAllEmployees();

=======
>>>>>>> AlexBranch
    Employee getEmployeeById(int employee_id);

    Employee loginEmployee(String username, String password);

<<<<<<< HEAD
    List<Claim> getAllHandlerClaims(int handler_employee_id);
=======
    List<Claim> getAllClaims(int handler_employee_id);
>>>>>>> AlexBranch

    List<Claim> getUserClaimsByAgent(int agent_employee_id);

    List<Debrief> getAllAgentDebriefings(int handler_employee_id);

    List<Debrief> getAgentDebriefings(int agent_employee_id);

    List<String> getLeaderboard();
<<<<<<< HEAD

    boolean insertEmployeeImage(int employee_id, File file);

    String getEmployeeImage(int employee_id);
=======
>>>>>>> AlexBranch
}
