package projeto01_ms.book_user.Adapter.InBound;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto01_ms.book_user.Application.InBound.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class ControllerUser {

    private final RegisterUserUseCase registerUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public ControllerUser(
            RegisterUserUseCase registerUserUseCase,
            FindUserUseCase findUserUseCase,
            ListUsersUseCase listUsersUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    // CREATE
    @PostMapping("/register")
    public ResponseEntity<DtoRegisterUserResponse> registerUser(
            @RequestBody @Valid DtoRegisterUserRequest dto
    ) {
        var command = new RegisterUserCommand(dto.nome(), dto.Email(), dto.password());
        var output = registerUserUseCase.execute(command);
        var response = new DtoRegisterUserResponse(output.userId(), output.email());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ - todos
    @GetMapping
    public ResponseEntity<List<DtoUserResponse>> listUsers() {
        var response = listUsersUseCase.execute().stream()
                .map(output -> new DtoUserResponse(
                        output.userId(),
                        output.name(),
                        output.email(),
                        output.roles(),
                        output.createdAt(),
                        output.updatedAt()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    // READ - por id
    @GetMapping("/{id}")
    public ResponseEntity<DtoUserResponse> findUser(@PathVariable UUID id) {
        var output = findUserUseCase.execute(id);
        var response = new DtoUserResponse(
                output.userId(),
                output.name(),
                output.email(),
                output.roles(),
                output.createdAt(),
                output.updatedAt()
        );

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<DtoUserResponse> updateUser(
            @PathVariable UUID id,
            @RequestBody @Valid DtoUpdateUserRequest dto
    ) {
        var command = new UpdateUserCommand(id, dto.nome(), dto.email(), dto.password());
        var output = updateUserUseCase.execute(command);
        var response = new DtoUserResponse(
                output.userId(),
                output.name(),
                output.email(),
                output.roles(),
                output.createdAt(),
                output.updatedAt()
        );

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
        deleteUserUseCase.execute(id);
    }
}
