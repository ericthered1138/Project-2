package daos.claim;

import entities.Claim;


public interface ClaimDAO
{
    int maxCreator();

    Claim getClaimById(int claimId);

    Claim createClaim(Claim claim);

    Claim approveClaim(int claimId);

    Claim denyClaim(int claimId);
}
