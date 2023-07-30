package com.example.tamagotchibackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object that allows transferring only a Tamagotchi's status conditions for updating / displaying on
 * the frontend.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    private int hunger;
    private int happiness;
    private int cleanliness;
    private int age;
}
