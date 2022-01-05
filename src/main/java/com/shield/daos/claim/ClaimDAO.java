package com.shield.daos.claim;

import com.shield.entities.Claim;


public interface ClaimDAO
{
    int maxCreator();

    Claim getClaimById(int claimId);

    Claim createClaim(Claim claim);

    Claim approveClaim(int claimId, String handlerComment);

    Claim denyClaim(int claimId, String handlerComment);

    Claim approveClaim(int claimId);

    Claim denyClaim(int claimId);
}
