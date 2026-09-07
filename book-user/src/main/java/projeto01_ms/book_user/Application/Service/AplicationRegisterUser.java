package projeto01_ms.book_user.Application.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.Entity.ROLE;
import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.InBound.RegisterUserCommand;
import projeto01_ms.book_user.Application.InBound.RegisterUserUseCase;
import projeto01_ms.book_user.Application.OutBound.RegisterUserOutPut;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;
import projeto01_ms.book_user.Domain.EmailAlreadyExistExceptions;

@Service
public class AplicationRegisterUser implements RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;

    public AplicationRegisterUser(UserRepositoryPort userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterUserOutPut execute(RegisterUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new EmailAlreadyExistExceptions(command.email());
        }

        User user = new User(
                command.name(),
                command.email(),
                passwordEncoder.encode(command.password())
        );
        user.getRoles().add(ROLE.BUYER);

        User savedUser = userRepository.save(user);

        return new RegisterUserOutPut(savedUser.getID(), savedUser.getEmail());
    }
}
