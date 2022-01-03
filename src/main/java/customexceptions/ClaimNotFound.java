package customexceptions;

public class ClaimNotFound extends RuntimeException{
    public ClaimNotFound(String message){
        super(message);
    }
}
