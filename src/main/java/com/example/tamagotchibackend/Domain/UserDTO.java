package com.example.tamagotchibackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object that allows transferring only the relevant information for logging in / registering users.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    //private Integer id;
    private String username;
    private String password;
}
