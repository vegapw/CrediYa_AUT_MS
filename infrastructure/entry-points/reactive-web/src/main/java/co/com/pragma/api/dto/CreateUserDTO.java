package co.com.pragma.api.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.NonNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Builder
public record CreateUserDTO(

        BigInteger idNumber,
        Byte idType,
        @NotBlank(message = "Firstname is required")
        String firstName,
        String middleName,
        @NotBlank(message = "Lastname is required")
        String lastName,
        String secondLastName,
        LocalDate birthDate,
        String address,
        Long phoneNumber,
        @NotBlank(message = "Email is required")
        @NonNull
        @Email
        String email,
        @NotNull
        @DecimalMin(value = "0.0", message = "BaseSalary must be greater or equal to 0")
        @DecimalMax(value = "15000000.0", message = "BaseSalary must be lesser or equal to 15'000.000")
        BigDecimal baseSalary) {
}
