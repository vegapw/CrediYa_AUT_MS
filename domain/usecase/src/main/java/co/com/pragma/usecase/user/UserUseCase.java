package co.com.pragma.usecase.user;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository repository;

    public Mono<User> saveUser(User user){
        return repository.existUserByEmail(user.getEmail())
                .flatMap( exist -> exist ?
                        Mono.error(new IllegalArgumentException("Email already exists.")) :
                        repository.saveUser(user));
    }

    public Flux<User> getAllUsers(){
        return repository.getAllUsers();
    }

    public Mono<User> getUserByIdNumber(BigInteger idNumber){
        return repository.getUserByIdNumber(idNumber);
    }

    public Mono<User> editUser(User user){
        return repository.editUser(user);
    }

    public Mono<Void> deleteUser(BigInteger idNumber){
        return repository.deleteById(idNumber);
    }
}
