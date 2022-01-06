package com.shield.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;
import io.javalin.http.Handler;
import com.shield.services.employee.EmployeeService;

import java.util.List;

public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

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
            ctx.status(100);
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
}
