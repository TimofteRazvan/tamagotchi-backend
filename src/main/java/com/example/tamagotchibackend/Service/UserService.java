package com.example.tamagotchibackend.Service;

import com.example.tamagotchibackend.Domain.TamagotchiDTO;
import com.example.tamagotchibackend.Domain.TamagotchiDTO;
import com.example.tamagotchibackend.Domain.User;
import com.example.tamagotchibackend.Domain.StatusDTO;
import com.example.tamagotchibackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * A Service class that allows communication between the Controller and the Repository, which also takes care of the
 * business logic.
 * The Repository is @Autowired via Dependency Injection from the Spring container.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Saves a User entity to the database and sets all Tamagotchi-related data to default.
     * Though a user can technically NOT have a Tamagotchi, they wouldn't be able to use the application, as ownership
     * is enforced.
     * @param username string representing name of the user we save
     * @param password string representing password of the user we save
     * @return the saved user
     */
    public User saveUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setTamagotchiName("");
        user.setTamagotchiSpecies("");
        user.setHunger(100);
        user.setHappiness(100);
        user.setCleanliness(100);
        user.setAge(0);
        return userRepository.save(user);
    }

    /**
     * Checks if the entered username & password coincide by finding the user via username and then equating the password.
     * @param username string representing name of the user
     * @param password string representing password of the user
     * @return the user, if password is correct | null, otherwise
     */
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (Objects.equals(user.getPassword(), password)) {
            return user;
        }
        else {
            return null;
        }
    }

    /**
     * Creates a Tamagotchi by filling in an existing User's details with the given Tamagotchi data.
     * @param id integer representing id of the user who created a Tamagotchi
     * @param tamagotchiDTO the data of the Tamagotchi to be created
     * @return the complete user
     */
    public User createTamagotchi(Integer id, TamagotchiDTO tamagotchiDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        user.setTamagotchiName(tamagotchiDTO.getName());
        user.setTamagotchiSpecies(tamagotchiDTO.getSpecies());
        user.setHappiness(100);
        user.setHunger(100);
        user.setCleanliness(100);
        user.setAge(0);
        return userRepository.save(user);
    }

    /**
     * Deletes Tamagotchi-related data from a User, forcing them to create another should they continue.
     * @param id integer representing id of the user whose Tamagotchi died
     * @return "OK" string for quick checking
     */
    public String killTamagotchi(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        user.setTamagotchiName("");
        user.setTamagotchiSpecies("");
        userRepository.save(user);
        return "OK";
    }

    /**
     * Returns the Tamagotchi's status in order to be displayed to the frontend, from a certain User.
     * @param userId integer representing id of the user whose Tamagotchi status we need
     * @return the User's Tamagotchi's current status
     */
    public StatusDTO getStatus(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        return new StatusDTO(user.getHunger(), user.getHappiness(), user.getCleanliness(), user.getAge());
    }

    /**
     * Updates the Tamagotchi's status in order to be changed in the backend like in the frontend, from a certain User.
     * @param statusDTO the data of the Tamagotchi's current status
     * @param userId userId integer representing id of the user whose Tamagotchi status we need
     * @return the User's Tamagotchi's new status
     */
    public StatusDTO updateStatus(StatusDTO statusDTO, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        int happiness = statusDTO.getHappiness();
        int hunger = statusDTO.getHunger();
        int cleanliness = statusDTO.getCleanliness();
        int age = statusDTO.getAge();
        user.setHappiness(happiness);
        user.setHunger(hunger);
        user.setCleanliness(cleanliness);
        user.setAge(age);
        userRepository.save(user);
        return new StatusDTO(hunger, happiness, cleanliness, age);
    }
}
