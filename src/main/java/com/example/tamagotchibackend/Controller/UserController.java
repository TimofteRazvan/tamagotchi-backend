package com.example.tamagotchibackend.Controller;

import com.example.tamagotchibackend.Domain.Status;
import com.example.tamagotchibackend.Domain.Tamagotchi;
import com.example.tamagotchibackend.Domain.User;
import com.example.tamagotchibackend.Domain.UserDTO;
import com.example.tamagotchibackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("/register")
//    public void register(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//    }
//
//    @PostMapping("/register/save")
//    public void registerSave(@RequestBody User user) {
//        userService.saveUser(user);
//    }

    @PostMapping("/auth")
    public User login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/create-tamagotchi/{id}")
    public User createTamagotchi(@PathVariable Integer id, @RequestBody Tamagotchi tamagotchi) {
        return userService.createTamagotchi(id, tamagotchi);
    }

    @GetMapping("/home/{id}")
    public Status home(@PathVariable Integer id) {
        return userService.getStatus(id);
    }

    @PostMapping("/update-status/{id}")
    public Status updateStatus(@PathVariable Integer id, @RequestBody Status status) {
        return userService.updateStatus(status, id);
    }

    @GetMapping("/kill-tamagotchi/{id}")
    public String killTamagotchi(@PathVariable Integer id) {
        return userService.killTamagotchi(id);
    }
}
