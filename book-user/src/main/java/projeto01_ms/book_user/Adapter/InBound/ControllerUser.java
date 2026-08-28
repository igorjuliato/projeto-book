package projeto01_ms.book_user.Adapter.InBound;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto01_ms.book_user.Application.InBound.RegisterUserCommand;
import projeto01_ms.book_user.Application.InBound.RegisterUserUseCase;
import projeto01_ms.book_user.Application.OutBound.RegisterUserOutPut;

@RestController
@RequestMapping("/user")
public class ControllerUser {

    private final RegisterUserUseCase registerUserPort;

    public ControllerUser(RegisterUserUseCase registerUserPort){
        this.registerUserPort = registerUserPort;
    }

    //Esse endpoint é responsavel por cadastrar e definir status inicial do usuario(role)
    @PostMapping("/register")
    public ResponseEntity<DtoRegisterUserResponse> RegisterUser(@RequestBody @Valid DtoRegisterUserRequest dto){

        var command = new RegisterUserCommand(dto.nome(),dto.Email(),dto.password());

        var OutPut = registerUserPort.execute(command);

        var Response = new DtoRegisterUserResponse(OutPut.userId(), OutPut.email());

        return ResponseEntity.status(HttpStatus.CREATED).body(Response);
    }

    //Validar senha do usuario no registro e autenticar o usuario
    @PostMapping()
    public ResponseEntity<> AuthenticateUser(){

    }


    //Esse endpoint é responsavel por atualizar
    @PutMapping("/uptade/{id}")
    public ResponseEntity<> UpdateUser(){

    }


    //Esse endpoint é responsavel por desativar o usuario
    @PostMapping("/renew")
    public ResponseEntity<> renewUser(){

    }

}
