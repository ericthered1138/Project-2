package services;

import entities.Debrief;

public interface DebriefService {

    Debrief getDebriefService(int debriefing_id);

    Debrief createDebriefService(Debrief debrief);
}
