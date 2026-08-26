package projeto01_ms.book_user.Application.Service;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Adapter.OutBound.UserRepositoryAdapter;
import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.InBound.RegisterUserCommand;
import projeto01_ms.book_user.Application.InBound.RegisterUserUseCase;
import projeto01_ms.book_user.Application.OutBound.RegisterUserOutPut;

@Service
public class AplicationRegisterUser implements RegisterUserUseCase  {

    private final UserRepositoryAdapter userRepository;


    public AplicationRegisterUser(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserOutPut execute(RegisterUserCommand command) {
        if (userRepository.existByEmail(command.email())) {

        }
        User user = new User(
                command.name(),
                command.email(),
                command.password()
        );

        User saveUser = userRepository.save(user);

        return new RegisterUserOutPut(
                saveUser.getID(),
                saveUser.getEmail()
        );
    }
}
