package tests.service;

import daos.DebriefDAO;
import daos.DebriefDAOImp;
import services.DebriefService;
import services.DebriefServiceImp;

public class DebriefServiceTests {
    DebriefDAO debriefDao = new DebriefDAOImp();
    DebriefService debriefService = new DebriefServiceImp(debriefDao);

}
