package co.com.pragma.r2dbc.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Table("users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id_number")
    private BigInteger idNumber;
    @Column("id_type")
    private Byte idType;
    @Column("first_name")
    private String firstName;
    @Column("middle_name")
    private String middleName;
    @Column("last_name")
    private String lastName;
    @Column("second_last_name")
    private String secondLastName;
    @Column("birth_date")
    private LocalDate birthDate;
    private String address;
    @Column("phone_number")
    private Long phoneNumber;
    private String email;
    @Column("base_salary")
    private BigDecimal baseSalary;
}
