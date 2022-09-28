package com.library.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_account", uniqueConstraints = {@UniqueConstraint(name = "EmailAndPhoneNumberConstrain", columnNames = {"email", "phone_number"})})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull(message = "Name cannot be empty!")
    @Column(name = "name")
    String name;

    @NotNull(message = "Phone number cannot be empty!")
    @Column(name = "phone_number")
    String phoneNumber;

    @NotNull(message = "Email cannot be empty!")
    @Column(name = "email")
    String email;

    @NotNull(message = "Role cannot be empty!")
    @Column(name = "role")
    String role;

    @NotNull(message = "Password cannot be empty!")
    @Column(name = "password")
    String password;

    @Column(name = "password_salt")
    String passwordSalt;

    @NotNull(message = "Token cannot be empty!")
    @Column(name = "token")
    String token;
}
