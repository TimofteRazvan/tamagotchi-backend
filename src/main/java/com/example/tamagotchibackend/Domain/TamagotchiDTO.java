package com.example.tamagotchibackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object that allows transferring only immutable Tamagotchi data, used for creating a Tamagotchi.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TamagotchiDTO {
    private String name;
    private String species;
}
