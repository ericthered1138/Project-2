package controllers;

import com.google.gson.Gson;
import customexceptions.InvalidPassword;
import customexceptions.InvalidUsername;
import customexceptions.UserNotFound;
import entities.User;
import io.javalin.http.Handler;
import services.user.UserServices;

import java.util.List;

public class UserController {

    UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    public Handler getUser = ctx -> {
        int userId = Integer.parseInt(ctx.pathParam("userId"));
        try{
            User user = this.userServices.getUserByIdService(userId);
            Gson gson = new Gson();
            String userJson = gson.toJson(user);
            ctx.result(userJson);
            ctx.status(200);
        } catch (UserNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllUsers = ctx -> {
        List<User> users = this.userServices.getAllUserService();
        Gson gson = new Gson();
        String userJSONs = gson.toJson(users);
        ctx.result(userJSONs);
        ctx.status(200);
    };

    public Handler checkUserLogin = ctx -> {
        try{
            Gson gson = new Gson();
            User jsonInfo = gson.fromJson(ctx.body(), User.class);
            String username = jsonInfo.getUsername();
            String passcode = jsonInfo.getPasscode();
            User user = this.userServices.checkUserLoginService(username, passcode);
            String checkedUser = gson.toJson(user);
            ctx.result(checkedUser);
            ctx.status(200);

        } catch (InvalidUsername | InvalidPassword e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler createUser = ctx -> {
        Gson gson = new Gson();
        User newUser = gson.fromJson(ctx.body(), User.class);
        User createdUser = this.userServices.createUser(newUser);
        String createdUserJson = gson.toJson(createdUser);
        ctx.result(createdUserJson);
        ctx.status(201);
    };
}
