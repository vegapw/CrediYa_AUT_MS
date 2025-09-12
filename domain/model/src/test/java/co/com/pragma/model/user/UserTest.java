package co.com.pragma.model.user;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void createUserTest(){
        BigInteger id = BigInteger.ONE;
        Byte idType = 2;
        String firstName = "Juan";
        String lastName = "Kirk";
        LocalDate birthDate = LocalDate.of(2000, 12, 5);
        String address = "Carrera 44 # 53sur";
        Long phone = 3167509037L;
        String email = "juan.kirk@gmail.com";
        BigDecimal baseSalary = BigDecimal.valueOf(11000000L);

        User user = new User(id, idType, firstName, "", lastName, "",
                birthDate, address, phone, email, baseSalary);

        assertNotNull(user);
        assertEquals(id, user.getIdNumber());
        assertEquals("", user.getMiddleName());
        assertEquals("", user.getSecondLastName());
        assertEquals(idType, user.getIdType());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(phone, user.getPhoneNumber());
        assertEquals(address, user.getAddress());
        assertEquals(email, user.getEmail());
        assertEquals(baseSalary, user.getBaseSalary());
    }

    @Test
    void createUserWithBuilderTest(){
        BigInteger id = BigInteger.TWO;
        Byte idType = 1;
        String firstName = "Caroline";
        String lastName = "Kirk";
        LocalDate birthDate = LocalDate.of(2005, 11, 7);
        String address = "Carrera 44 # 53sur";
        Long phone = 3187589047L;
        String email = "caro.kirk@gmail.com";
        BigDecimal baseSalary = BigDecimal.valueOf(9000000L);

        User user = User.builder()
                .idNumber(id)
                .idType(idType)
                .firstName(firstName)
                .middleName("")
                .lastName(lastName)
                .secondLastName("")
                .address(address)
                .phoneNumber(phone)
                .birthDate(birthDate)
                .email(email)
                .baseSalary(baseSalary)
                .build();

        assertNotNull(user);
        assertEquals(id, user.getIdNumber());
        assertEquals("", user.getMiddleName());
        assertEquals("", user.getSecondLastName());
        assertEquals(idType, user.getIdType());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(phone, user.getPhoneNumber());
        assertEquals(address, user.getAddress());
        assertEquals(email, user.getEmail());
        assertEquals(baseSalary, user.getBaseSalary());
    }

    @Test
    void updateUserWithSettersTest(){
        BigInteger id = BigInteger.TEN;
        Byte idType = 2;
        String firstName = "Juan";
        String lastName = "Kirk";
        LocalDate birthDate = LocalDate.of(2000, 12, 5);
        String address = "Carrera 44 # 53sur";
        Long phone = 3167509037L;
        String email = "juan.kirk@gmail.com";
        BigDecimal baseSalary = BigDecimal.valueOf(11000000L);


        User user = new User();

        user.setIdNumber(id);
        user.setIdType(idType);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName("");
        user.setSecondLastName("");
        user.setBirthDate(birthDate);
        user.setAddress(address);
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setBaseSalary(baseSalary);

        assertNotNull(user);
        assertEquals(id, user.getIdNumber());
        assertEquals("", user.getMiddleName());
        assertEquals("", user.getSecondLastName());
        assertEquals(idType, user.getIdType());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(phone, user.getPhoneNumber());
        assertEquals(address, user.getAddress());
        assertEquals(email, user.getEmail());
        assertEquals(baseSalary, user.getBaseSalary());
    }

    @Test
    void updateUserWithBuilderTest(){
        BigInteger id = BigInteger.TWO;
        Byte idType = 1;
        String firstName = "Caroline";
        String lastName = "Kirk";
        LocalDate birthDate = LocalDate.of(2005, 11, 7);
        String address = "Carrera 44 # 53sur";
        Long phone = 3187589047L;
        String email = "caro.kirk@gmail.com";
        BigDecimal baseSalary = BigDecimal.valueOf(9000000L);

        User user = User.builder()
                .idNumber(id)
                .idType(idType)
                .firstName(firstName)
                .middleName("")
                .lastName(lastName)
                .secondLastName("")
                .address(address)
                .phoneNumber(phone)
                .birthDate(birthDate)
                .email(email)
                .baseSalary(baseSalary)
                .build();

        String addressUpdated = "Street 53 south 44";
        BigDecimal baseSalaryUpdated = BigDecimal.valueOf(13000000L);

        User updatedUser = user.toBuilder()
                .address(addressUpdated)
                .baseSalary(baseSalaryUpdated)
                .build();

        assertEquals(id, updatedUser.getIdNumber());
        assertEquals(addressUpdated, updatedUser.getAddress());
        assertEquals(baseSalaryUpdated, updatedUser.getBaseSalary());
    }
}
