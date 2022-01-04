package com.shield.controllers;

import com.shield.services.claim.ClaimService;
import io.javalin.http.Handler;
import com.google.gson.Gson;
import com.shield.entities.Claim;
import com.shield.customexceptions.ClaimNotFound;

public class ClaimController {

    ClaimService claimService;
    public ClaimController(ClaimService claimService){
        this.claimService = claimService;
    }

    public Handler getClaim = ctx -> {
        int claimId = Integer.parseInt(ctx.pathParam("claimId"));
        try{
            Claim claim = this.claimService.getClaimByIdService(claimId);
            Gson gson = new Gson();
            String claimJson = gson.toJson(claim);
            ctx.result(claimJson);
            ctx.status(200);
        }
        catch (ClaimNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler createClaim = ctx -> {
        Gson gson = new Gson();
        Claim newClaim = gson.fromJson(ctx.body(), Claim.class);
        System.out.println(newClaim);
        Claim createdClaim = this.claimService.createClaimService(newClaim);
        String createdClaimJson = gson.toJson(createdClaim);
        ctx.result(createdClaimJson);
        ctx.status(201);
    };

    public Handler approveClaim = ctx -> {
        int claimId = Integer.parseInt(ctx.pathParam("claimId"));
        try{
            Claim claim = this.claimService.approveClaimService(claimId);
            Gson gson = new Gson();
            String claimJson = gson.toJson(claim);
            ctx.result(claimJson);
            ctx.status(200);
        }
        catch (ClaimNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler denyClaim = ctx -> {
        int claimId = Integer.parseInt(ctx.pathParam("claimId"));
        try{
            Claim claim = this.claimService.denyClaimService(claimId);
            Gson gson = new Gson();
            String claimJson = gson.toJson(claim);
            ctx.result(claimJson);
            ctx.status(200);
        }
        catch (ClaimNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}
