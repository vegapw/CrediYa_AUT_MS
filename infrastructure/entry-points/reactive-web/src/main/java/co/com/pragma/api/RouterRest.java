package co.com.pragma.api;

import co.com.pragma.api.config.UsersPath;
import co.com.pragma.api.openapi.UserOpenApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;

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



/*
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/usecase/path"), handler::listenGETUseCase)
                .andRoute(POST("/api/usecase/otherpath"), handler::listenPOSTUseCase)
                .and(route(GET("/api/otherusercase/path"), handler::listenGETOtherUseCase));
    }

 */
}
