package app;

import controllers.UserController;
import daos.user.UserDAO;
import daos.user.UserDAOImp;
import services.user.UserServices;
import services.user.UserServicesImp;
import controllers.AppController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config ->{
           config.enableCorsForAllOrigins();
           config.enableDevLogging();
        });

        UserDAO userDAO = new UserDAOImp();
        UserServices userServices = new UserServicesImp(userDAO);
        UserController userController = new UserController(userServices);
        AppController appController = new AppController();

        app.get("/", appController.hello);

        app.get("/user/{userId}", userController.getUser);

        app.get("/users", userController.getAllUsers);

        app.get("/login", userController.checkUserLogin);

        app.post("/newUser", userController.createUser);


        app.start();
    }
}
