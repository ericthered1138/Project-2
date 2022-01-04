package com.shield.services.debrief;

import com.shield.entities.Debrief;

public interface DebriefService {

    Debrief getDebriefService(int debriefing_id);

    Debrief createDebriefService(Debrief debrief);
}
