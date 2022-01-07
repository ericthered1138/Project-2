package com.shield.controllers;

import com.google.gson.Gson;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.entities.Debrief;
import io.javalin.http.Handler;
import com.shield.services.debrief.DebriefService;

public class DebriefController {

    DebriefService debriefService;
    public DebriefController(DebriefService debriefService){this.debriefService = debriefService;}

    public Handler getDebrief = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));//debrief id
        try{
            Debrief debrief = this.debriefService.getDebriefService(id);
            Gson gson = new Gson();
            String debriefJson = gson.toJson(debrief);
            ctx.result(debriefJson);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler createDebrief = ctx ->{
        Gson gson = new Gson();
        Debrief newDebrief = gson.fromJson(ctx.body(), Debrief.class);
        System.out.println(newDebrief);
        Debrief createdDebrief = this.debriefService.createDebriefService(newDebrief);
        String createdDebriefJson = gson.toJson(createdDebrief);
        ctx.result(createdDebriefJson);
        ctx.status(201);
    };

}
