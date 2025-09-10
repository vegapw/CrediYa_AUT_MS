package co.com.pragma.api;

import co.com.pragma.api.dto.CreateUserDTO;
import co.com.pragma.api.dto.UserDTO;
import co.com.pragma.api.exception.UserValidationException;
import co.com.pragma.api.mapper.UserDTOMapper;
import co.com.pragma.model.user.User;
import co.com.pragma.usecase.user.UserUseCase;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;
    private final UserDTOMapper userDTOMapper;
    private final Validator validator;

    public Mono<ServerResponse> listenGetAllUsers(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userUseCase.getAllUsers(), UserDTO.class);
    }

    public Mono<ServerResponse> listenGetUserById(ServerRequest request){
        return Mono.fromCallable(() -> request.pathVariable("id"))
                .map(String::trim)
                .filter(item -> !item.isBlank())
                .map(BigInteger::new)
                .flatMap(userUseCase::getUserByIdNumber)
                .flatMap(user -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> listenSaveUser(ServerRequest request){
        return request.bodyToMono(CreateUserDTO.class)
                .flatMap(this::validateRequest)
                .map(userDTOMapper::toModel)
                .flatMap(userUseCase::saveUser)
                .flatMap( savedUser -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedUser));

    }

    private Mono<CreateUserDTO> validateRequest(CreateUserDTO userDTO){
        Errors errors = new BeanPropertyBindingResult(userDTO, CreateUserDTO.class.getName());
        validator.validate(userDTO, errors);
        if (errors.hasErrors()){
            Map<String, List<String>> map = errors.getFieldErrors()
                    .stream()
                    .collect(Collectors.groupingBy(
                            FieldError::getField,
                            Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                    ));
            throw new UserValidationException(map);
        }
        return Mono.just(userDTO);
    }

}
