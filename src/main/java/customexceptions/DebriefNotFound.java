package customexceptions;

public class DebriefNotFound extends RuntimeException{
    public DebriefNotFound(String message){
        super(message);
    }
}
