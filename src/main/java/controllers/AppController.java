package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customexceptions.InvalidPassword;
import customexceptions.InvalidUsername;
import customexceptions.UserNotFound;
import entities.User;
import io.javalin.http.Handler;
import services.user.UserServices;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AppController {

    public Handler hello = (ctx) ->{
        ctx.result("Hello there!");
        ctx.status(200);
    };

}
