package co.com.pragma.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EditUserDTO(Byte idType, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, String address, Long phoneNumber, String email, BigDecimal baseSalary) {
}
