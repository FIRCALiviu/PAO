package errors;

public class InvalidEmail extends Exception{
    public InvalidEmail(String msg){
        super((msg));
    }
    public InvalidEmail(){

    }
}
