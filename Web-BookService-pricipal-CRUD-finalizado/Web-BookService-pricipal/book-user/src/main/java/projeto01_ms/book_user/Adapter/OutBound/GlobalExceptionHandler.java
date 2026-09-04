package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projeto01_ms.book_user.Domain.EmailAlreadyExistExceptions;
import projeto01_ms.book_user.Domain.UserNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EmailAlreadyExistExceptions.class)
  public ResponseEntity<ErrorResponse> HandlerEmailAlreadyExist(EmailAlreadyExistExceptions mensagem){
    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponse(mensagem));
  }
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handlerUserNotFound(UserNotFoundException mensagem){
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(mensagem));
  }

}
