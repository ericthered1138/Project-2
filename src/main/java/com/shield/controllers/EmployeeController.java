package com.shield.controllers;

import com.google.gson.Gson;
<<<<<<< HEAD
import com.google.gson.JsonSyntaxException;
=======
>>>>>>> AlexBranch
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;
import io.javalin.http.Handler;
import com.shield.services.employee.EmployeeService;
<<<<<<< HEAD
import io.netty.handler.codec.base64.Base64Encoder;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
=======

>>>>>>> AlexBranch
import java.util.List;

public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

<<<<<<< HEAD
    public Handler getAllEmployees = ctx -> {
        List<Employee> employees = this.employeeService.getAllEmployeesService();
        Gson gson = new Gson();
        String employeeJson = gson.toJson(employees);
        ctx.result(employeeJson);
        ctx.status(200);
    };

    public Handler getEmployee = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try{
            Employee employee = this.employeeService.getEmployeeByIdService(id);//employeeId
=======
    public Handler getEmployee = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try{
            Employee employee = this.employeeService.getEmployeeByIdService(id);
>>>>>>> AlexBranch
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
<<<<<<< HEAD
        try {
            Gson gson = new Gson();
            Employee loginEmployee = gson.fromJson(ctx.body(), Employee.class);
            String username = loginEmployee.getUsername();
            String passcode = loginEmployee.getPasscode();
            Employee employee = this.employeeService.loginEmployeeService(username, passcode);
            String EmployeeJson = gson.toJson(employee);
            ctx.result(EmployeeJson);
            ctx.status(201);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllHandlerClaims = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));//handler Id
            Gson gson = new Gson();
            List<Claim> claims = this.employeeService.getAllClaimsService(id);
            String claimsJSONs = gson.toJson(claims);
            ctx.result(claimsJSONs);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAgentClaims = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));//agent id
            Gson gson = new Gson();
            List<Claim> claims = this.employeeService.getUserClaimsByAgentService(id);
            String claimsJSONs = gson.toJson(claims);
            ctx.result(claimsJSONs);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllAgentDebriefs = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));//handler id
            Gson gson = new Gson();
            List<Debrief> debriefs = this.employeeService.getAllAgentDebriefingsService(id);
            String debriefsJSONs = gson.toJson(debriefs);
            ctx.result(debriefsJSONs);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAgentDebriefs = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));//agent id
            Gson gson = new Gson();
            List<Debrief> debriefs = this.employeeService.getAgentDebriefingsService(id);
            String debriefsJSONs = gson.toJson(debriefs);
            ctx.result(debriefsJSONs);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getLeaderboard = ctx ->{
        try {
            Gson gson = new Gson();
            List<String> leaderboard = this.employeeService.getLeaderboardService();
            String leaderboards = gson.toJson(leaderboard.toArray());
            ctx.result(leaderboards);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getImage = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));//employee id
            String image_returned = this.employeeService.getEmployeeImageService(id);
            ctx.result(image_returned);
            ctx.status(200);
        } catch (EmployeeNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
=======
        Gson gson = new Gson();
        Employee loginEmployee = gson.fromJson(ctx.body(), Employee.class);
        String username = loginEmployee.getUsername();
        String passcode = loginEmployee.getPasscode();
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
>>>>>>> AlexBranch
    };
}
