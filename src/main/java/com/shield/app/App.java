package com.shield.app;

import com.shield.controllers.AppController;
import com.shield.controllers.DebriefController;
import com.shield.controllers.EmployeeController;
import com.shield.controllers.UserController;
import com.shield.daos.debrief.DebriefDAO;
import com.shield.daos.debrief.DebriefDAOImp;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import com.shield.daos.user.UserDAO;
import com.shield.daos.user.UserDAOImp;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;
import io.javalin.Javalin;
import com.shield.services.debrief.DebriefService;
import com.shield.services.debrief.DebriefServiceImp;
import com.shield.services.employee.EmployeeService;
import com.shield.services.employee.EmployeeServiceImp;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config ->{
           config.enableCorsForAllOrigins();
           config.enableDevLogging();
        });

        AppController appController = new AppController();
        app.get("/", appController.hello);

        EmployeeDAO employeeDAO = new EmployeeDAOImp();
        EmployeeService employeeService = new EmployeeServiceImp(employeeDAO);
        EmployeeController employeeController = new EmployeeController(employeeService);

        DebriefDAO debriefDAO = new DebriefDAOImp();
        DebriefService debriefService = new DebriefServiceImp(debriefDAO, employeeDAO);
        DebriefController debriefController = new DebriefController(debriefService);

        app.get("/employee/{id}", employeeController.getEmployee);
        app.post("/employee/login", employeeController.loginEmployee);
        app.get("/employee/claims/all/{id}", employeeController.getAllClaims);
        app.get("/employee/debriefs/all/{id}", employeeController.getAllAgentDebriefs);
        app.get("/employee/debriefs/{id}", employeeController.getAgentDebriefs);
        app.get("/user/claims/{id}", employeeController.getUserClaims);
        app.get("/employee/claims/{id}", employeeController.getAgentClaims);

        app.get("/debrief/{id}", debriefController.getDebrief);
        app.post("/debrief", debriefController.createDebrief);

        UserDAO userDAO = new UserDAOImp();
        UserServices userServices = new UserServicesImp(userDAO);
        UserController userController = new UserController(userServices);


        app.get("/user/{userId}", userController.getUser);

        app.get("/users", userController.getAllUsers);

        app.post("/login", userController.checkUserLogin);

        app.post("/newUser", userController.createUser);



        app.start();
    }
}
