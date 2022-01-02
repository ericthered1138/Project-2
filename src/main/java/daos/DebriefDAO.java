package daos;

import entities.Debrief;

public interface DebriefDAO {
    int maxCreator();

    Debrief getDebrief(int debriefing_id);

    Debrief createDebrief(Debrief debrief);
}
