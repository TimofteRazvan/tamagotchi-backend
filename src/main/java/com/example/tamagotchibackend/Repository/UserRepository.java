package com.example.tamagotchibackend.Repository;

import com.example.tamagotchibackend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository that communicates with the Database via JpaRepository interface.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Using Jpa's shortened functions, it does a QUERY of SELECT * FROM users WHERE username == @username.
     * @param username a string representing the name of the user we want to find
     * @return the user with the specified username
     */
    User findByUsername(String username);
}
