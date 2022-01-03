package app;

import controllers.AppController;
import controllers.EmployeeController;
import daos.EmployeeDAO;
import daos.EmployeeDAOImp;
import io.javalin.Javalin;
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

        app.get("/employee/{id}", employeeController.getEmployee);
        app.post("/employee/login", employeeController.loginEmployee);

        app.start();
    }
}
