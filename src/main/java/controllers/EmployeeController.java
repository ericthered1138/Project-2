package controllers;

import com.google.gson.*;
import customexceptions.EmployeeNotFound;
import entities.Claim;
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
        //copied from https://stackoverflow.com/questions/22310143/java-8-localdatetime-deserialized-using-gson
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                (json, type, jsonDeserializationContext) ->
                        LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())).create();
        List<Claim> claims = this.employeeService.getAllClaimsService(id);
        System.out.println(claims);
        String claimsJSONs = gson.toJson(claims);
        System.out.println(claimsJSONs);
        ctx.result(claimsJSONs);
        ctx.status(200);
    };
}
