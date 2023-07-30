package com.example.tamagotchibackend.Domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User class contains information about each user that has been registered.
 * NO separate Tamagotchi class, as there can be no Tamagotchi without an user, and every user must have a Tamagotchi.
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    // No reason for a one-to-one relationship, as a user cannot NOT have a tamagotchi.
    private String tamagotchiName;
    private String tamagotchiSpecies;
    private int hunger;
    private int happiness;
    private int cleanliness;
    private int age;
}
