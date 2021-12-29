package app;

import controllers.AppController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config ->{
           config.enableCorsForAllOrigins();
           config.enableDevLogging();
        });

        AppController appController = new AppController();

        app.get("/", appController.hello);

        app.start();
    }
}
