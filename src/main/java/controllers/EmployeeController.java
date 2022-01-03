package controllers;

import com.google.gson.Gson;
import customexceptions.EmployeeNotFound;
import entities.Employee;
import io.javalin.http.Handler;
import services.EmployeeService;

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
}
