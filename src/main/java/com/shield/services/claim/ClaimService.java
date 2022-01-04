package com.shield.services.claim;


import com.shield.entities.Claim;

public interface ClaimService {

    Claim getClaimByIdService(int claimId);

    Claim createClaimService(Claim claim);

    Claim approveClaimService(int claimId);

    Claim denyClaimService(int claimId);

}
