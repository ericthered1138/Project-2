package services;

import customexceptions.EmployeeIsNotAgent;
import daos.DebriefDAO;
import daos.EmployeeDAO;
import entities.Debrief;
import entities.Employee;

public class DebriefServiceImp implements DebriefService{

    EmployeeDAO employeeDAO;
    DebriefDAO debriefDAO;
    public DebriefServiceImp(DebriefDAO debriefDAO, EmployeeDAO employeeDAO) {
        this.debriefDAO = debriefDAO;
        this.employeeDAO = employeeDAO;
    }


    @Override
    public Debrief getDebriefService(int debriefing_id) {
        return this.debriefDAO.getDebrief(debriefing_id);
    }

    @Override
    public Debrief createDebriefService(Debrief debrief) {
        //Check if the agent exists.
        Employee employee = employeeDAO.getEmployeeById(debrief.getEmployeeId());

        //Check to make sure the employee is not a handler.
        if (!employee.isHandler()){
            return this.debriefDAO.createDebrief(debrief);
        }else{
            throw new EmployeeIsNotAgent("That employee is not an agent.");
        }
    }
}
