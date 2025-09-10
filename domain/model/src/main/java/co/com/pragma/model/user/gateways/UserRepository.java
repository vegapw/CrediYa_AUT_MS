package co.com.pragma.model.user.gateways;

import co.com.pragma.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface UserRepository {

    Mono<User> saveUser(User user);
    Flux<User> getAllUsers();
    Mono<User> getUserByIdNumber(BigInteger idNumber);
    Mono<User> editUser(User user);
    Mono<Void> deleteById(BigInteger idNumber);
    Mono<Boolean> existUserByEmail(String email);

}
