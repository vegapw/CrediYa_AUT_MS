package co.com.pragma.api.exception;

import co.com.pragma.api.dto.UserValidationErrorResponse;

import java.util.List;
import java.util.Map;

public class UserValidationException extends RuntimeException{

    private final UserValidationErrorResponse response;

    public UserValidationException(Map<String, List<String>> errors){
        super("Errors during validation: " + errors.values());
        response = new UserValidationErrorResponse(List.of(errors));
    }

    public UserValidationErrorResponse getErrors() {
        return response;
    }
}
