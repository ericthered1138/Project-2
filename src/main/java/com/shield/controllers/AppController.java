package com.shield.controllers;

import io.javalin.http.Handler;

public class AppController {

    public Handler hello = (ctx) ->{
        ctx.result("Hello there!");
        ctx.status(200);
    };
}
