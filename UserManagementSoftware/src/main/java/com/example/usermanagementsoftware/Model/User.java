package com.example.usermanagementsoftware.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Check(constraints = "length(name) > 4 and length(username" +
        ") > 4 and (role = 'admin' or role = 'user') and age > 0")
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 4, message = "name must be longer than 4")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @NotEmpty(message = "username cannot be empty")
    @Size(min = 4, message = "username must be longer than 4 letters")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "enter valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "^(admin|user)$", message = "role must be either 'admin' or 'user'")
    @Column(columnDefinition = "varchar(5) not null")
    private String role;

    @NotNull(message = "age cannot be empty")
    @Min(value = 0, message = "age must be positive")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
