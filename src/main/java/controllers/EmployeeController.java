package controllers;

import com.google.gson.*;
import customexceptions.EmployeeNotFound;
import entities.Claim;
import entities.Debrief;
import entities.Employee;
import io.javalin.http.Handler;
import services.EmployeeService;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    public Handler getEmployee = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try{
            Employee employee = this.employeeService.getEmployeeByIdService(id);
            Gson gson = new Gson();
            String employeeJson = gson.toJson(employee);
            ctx.result(employeeJson);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler loginEmployee = ctx ->{
        Gson gson = new Gson();
        String username = ctx.formParam("username");
        String passcode = ctx.formParam("passcode");
        Employee employee = this.employeeService.loginEmployeeService(username, passcode);
        String EmployeeJson = gson.toJson(employee);
        ctx.result(EmployeeJson);
        ctx.status(201);
    };

    public Handler getAllClaims = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Gson gson = new Gson();
        List<Claim> claims = this.employeeService.getAllClaimsService(id);
        String claimsJSONs = gson.toJson(claims);
        ctx.result(claimsJSONs);
        ctx.status(200);
    };

    public Handler getUserClaims = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));// user id
        Gson gson = new Gson();
        List<Claim> claims = this.employeeService.getUserClaimsByUserService(id);
        System.out.println(claims);
        String claimsJSONs = gson.toJson(claims);
        ctx.result(claimsJSONs);
        ctx.status(200);
    };

    public Handler getAgentClaims = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//agent id
        Gson gson = new Gson();
        List<Claim> claims = this.employeeService.getUserClaimsByAgentService(id);
        String claimsJSONs = gson.toJson(claims);
        ctx.result(claimsJSONs);
        ctx.status(200);
    };

    public Handler getAllAgentDebriefs = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//handler id
        Gson gson = new Gson();
        List<Debrief> debriefs = this.employeeService.getAllAgentDebriefingsService(id);
        String debriefsJSONs = gson.toJson(debriefs);
        ctx.result(debriefsJSONs);
        ctx.status(200);
    };

    public Handler getAgentDebriefs = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//agent id
        Gson gson = new Gson();
        List<Debrief> debriefs = this.employeeService.getAgentDebriefingsService(id);
        String debriefsJSONs = gson.toJson(debriefs);
        ctx.result(debriefsJSONs);
        ctx.status(200);
    };
}
