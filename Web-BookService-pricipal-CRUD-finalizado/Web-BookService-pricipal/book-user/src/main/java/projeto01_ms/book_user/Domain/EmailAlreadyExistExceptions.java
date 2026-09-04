package projeto01_ms.book_user.Domain;

public class EmailAlreadyExistExceptions extends RuntimeException {
    public EmailAlreadyExistExceptions(String email){
     super("that email " + email + " already exist");
    }
}
