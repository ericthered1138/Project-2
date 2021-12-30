package daos;

import entities.Employee;

public interface EmployeeDAO {

    Employee getEmployeeById(int employee_id);

    Employee loginEmployee(String username, String password);

    Employee getAllClaims(int handler_employee_id);

    Employee getUserClaimsByUser(int user_id);

    Employee getUserClaimsByAgent(int agent_employee_id);

    Employee getAllAgentDebriefings(int handler_employee_id);

    Employee getAgentDebriefings(int agent_employee_id);

    Employee getLeaderboard();
}
