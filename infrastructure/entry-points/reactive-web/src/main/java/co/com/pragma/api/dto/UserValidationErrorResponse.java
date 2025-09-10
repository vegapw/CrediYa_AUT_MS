package co.com.pragma.api.dto;

import java.util.List;
import java.util.Map;

public record UserValidationErrorResponse (List<Map<String, List<String>>> errors) {
}
