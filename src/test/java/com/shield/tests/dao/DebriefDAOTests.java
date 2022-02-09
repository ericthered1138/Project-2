package com.shield.tests.dao;

import com.shield.daos.debrief.DebriefDAO;
import com.shield.daos.debrief.DebriefDAOImp;
import com.shield.entities.Debrief;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.shield.util.DatabaseTableCreator.table_depopulator;
import static com.shield.util.DatabaseTableCreator.table_populator;

public class DebriefDAOTests {

    DebriefDAO debriefDAOImp = new DebriefDAOImp();

    @BeforeClass
    void setup(){
        table_depopulator();
        table_populator();
    };

    @AfterClass
    void teardown(){
        table_depopulator();
    };

    @Test
    void getDebrief() {
        Debrief debrief = debriefDAOImp.getDebrief(1_000_001);
        System.out.println(debrief);
        System.out.println(debriefDAOImp.maxCreator());
        Assert.assertEquals(debrief.getDebriefingId(),1_000_001);
    }

    @Test
    void createDebrief() {
        Debrief test_debrief = debriefDAOImp.getDebrief(1_000_001);
        System.out.println(test_debrief);
        Debrief debrief = debriefDAOImp.createDebrief(test_debrief);
        System.out.println(debrief);
        Assert.assertEquals(debrief.getEmployeeId(),1_000_002);
    }
}
