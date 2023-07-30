package com.example.tamagotchibackend.Controller;

import com.example.tamagotchibackend.Domain.StatusDTO;
import com.example.tamagotchibackend.Domain.TamagotchiDTO;
import com.example.tamagotchibackend.Domain.TamagotchiDTO;
import com.example.tamagotchibackend.Domain.User;
import com.example.tamagotchibackend.Domain.UserDTO;
import com.example.tamagotchibackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A Controller class for communicating with the Frontend and handling requests.
 * The Service is @Autowired via Dependency Injection from the Spring container.
 */
@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Receives a POST REQUEST containing login data (username, password) for login validation.
     * @param userDTO login data (username, password)
     * @return the user, if validated | null, otherwise
     */
    @PostMapping("/auth")
    public User login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO.getUsername(), userDTO.getPassword());
    }

    /**
     * Receives a POST REQUEST containing user data (username, password) for user registration.
     * @param userDTO user data (username, password)
     * @return the saved user
     */
    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO.getUsername(), userDTO.getPassword());
    }

    /**
     * Receives a POST REQUEST containing tamagotchi data (name, species) for tamagotchi creation.
     * @param id integer representing id of user creating the tamagotchi
     * @param tamagotchiDTO tamagotchi data (name, species)
     * @return the complete user
     */
    @PostMapping("/create-tamagotchi/{id}")
    public User createTamagotchi(@PathVariable Integer id, @RequestBody TamagotchiDTO tamagotchiDTO) {
        return userService.createTamagotchi(id, tamagotchiDTO);
    }

    /**
     * Receives a GET REQUEST and an ID parameter contained in the URL for acquiring the current status of a user's
     * tamagotchi.
     * @param id integer representing id of user requesting their tamagotchi's status
     * @return the tamagotchi's status
     */
    @GetMapping("/home/{id}")
    public StatusDTO getStatus(@PathVariable Integer id) {
        return userService.getStatus(id);
    }

    /**
     * Receives a POST REQUEST containing status data and an ID parameter in the URL for updating the status of a user's
     * tamagotchi.
     * @param id integer representing id of user whose tamagotchi status is updated
     * @param statusDTO status data (hunger, happiness, cleanliness, age)
     * @return the tamagotchi's updated status
     */
    @PostMapping("/update-status/{id}")
    public StatusDTO updateStatus(@PathVariable Integer id, @RequestBody StatusDTO statusDTO) {
        return userService.updateStatus(statusDTO, id);
    }

    /**
     * Receives a GET REQUEST and an ID parameter contained in the URL for killing a user's tamagotchi.
     * @param id integer representing id of user whose tamagotchi has died
     * @return "OK" string
     */
    @GetMapping("/kill-tamagotchi/{id}")
    public String killTamagotchi(@PathVariable Integer id) {
        return userService.killTamagotchi(id);
    }
}
