package app;

import controllers.AppController;
import controllers.DebriefController;
import controllers.EmployeeController;
import daos.DebriefDAO;
import daos.DebriefDAOImp;
import daos.EmployeeDAO;
import daos.EmployeeDAOImp;
import io.javalin.Javalin;
import services.DebriefService;
import services.DebriefServiceImp;
import services.EmployeeService;
import services.EmployeeServiceImp;

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
        DebriefService debriefService = new DebriefServiceImp(debriefDAO);
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



        app.start();
    }
}
