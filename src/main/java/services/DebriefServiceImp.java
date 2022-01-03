package services;

import daos.DebriefDAO;
import entities.Debrief;

public class DebriefServiceImp implements DebriefService{

    DebriefDAO debriefDAO;
    public DebriefServiceImp(DebriefDAO debriefDAO) {this.debriefDAO = debriefDAO;}

    @Override
    public Debrief getDebriefService(int debriefing_id) {
        return this.debriefDAO.getDebrief(debriefing_id);
    }

    @Override
    public Debrief createDebriefService(Debrief debrief) {
        //Check to make sure the agent exists.

        //Check to make sure the employee is an agent.

        return this.debriefDAO.createDebrief(debrief);
    }
}
