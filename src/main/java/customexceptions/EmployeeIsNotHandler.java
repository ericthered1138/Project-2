package customexceptions;

public class EmployeeIsNotHandler extends RuntimeException{
    public EmployeeIsNotHandler(String message){
        super(message);
    }
}
