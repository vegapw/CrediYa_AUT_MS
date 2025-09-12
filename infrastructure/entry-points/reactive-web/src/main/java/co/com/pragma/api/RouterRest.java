package co.com.pragma.api;

import co.com.pragma.api.config.UsersPath;
import co.com.pragma.api.openapi.UserOpenApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RouterRest {

    private final Handler handler;
    private final UsersPath usersPath;

    @Bean
    public RouterFunction<ServerResponse> usersRouterFunction(){
        return route()
                .GET(usersPath.getUsers(), handler::listenGetAllUsers, UserOpenApi::getAllUsers)
                .POST(usersPath.getUsers(), handler::listenSaveUser, UserOpenApi::saveUser)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> usersByIdRouterFunction(){
        return RouterFunctions
                .route()
                .GET(usersPath.getUsersById(), handler::listenGetUserById)
                .build();
    }
}
