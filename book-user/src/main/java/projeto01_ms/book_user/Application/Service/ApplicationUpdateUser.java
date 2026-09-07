package projeto01_ms.book_user.Application.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.InBound.UpdateUserCommand;
import projeto01_ms.book_user.Application.InBound.UpdateUserUseCase;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;
import projeto01_ms.book_user.Domain.EmailAlreadyExistExceptions;
import projeto01_ms.book_user.Domain.UserNotFoundException;

@Service
public class ApplicationUpdateUser implements UpdateUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUpdateUser(UserRepositoryPort userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserOutPut execute(UpdateUserCommand command) {
        User user = userRepository.findById(command.id())
                .orElseThrow(() -> new UserNotFoundException(command.id()));

        userRepository.findBYEmail(command.email())
                .filter(foundUser -> !foundUser.getID().equals(command.id()))
                .ifPresent(foundUser -> {
                    throw new EmailAlreadyExistExceptions(command.email());
                });

        user.setName(command.name());
        user.setEmail(command.email());
        user.setPassword(passwordEncoder.encode(command.password()));

        return UserOutPutMapper.toOutput(userRepository.save(user));
    }
}
