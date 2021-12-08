package com.example.AccountSystemDemo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ApiController {

    ArrayList<User> users = new ArrayList<>();

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new UsernameExistsException();
            }
        }
        for (char ch : user.getUsername().toCharArray()) {
            if (((int)ch < 48) || (((int)ch > 57) && ((int)ch < 65)) || (((int)ch > 90) && ((int)ch < 97)) || ((int)ch > 122)) {
                throw new IncorrectUsernameExcetpion();
            }
        }
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @DeleteMapping("/users/{username}")
    public void deleteUserByUsername(@PathVariable("username") String username) {
        boolean found = false;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                found = true;
                if (u.getUsername().startsWith("admin")) {
                    throw new InsufficientRightsException();
                }
                users.remove(u);
            }
        }
        if (!found) {
            throw new UserNotFoundException();
        }
    }

    @PutMapping("/users/{username}")
    public void changePasswordByUsername(@PathVariable("username") String username, @RequestBody String newPassword) {
        boolean found = false;
        for (char ch : newPassword.toCharArray()) {
            if (((int)ch < 48) || (((int)ch > 57) && ((int)ch < 65)) || (((int)ch > 90) && ((int)ch < 97)) || ((int)ch > 122)) {
                throw new IncorrectUsernameExcetpion();
            }
        }
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                found = true;
                if (!u.getUsername().startsWith("update")) {
                    throw new InsufficientRightsException();
                }
                u.setPassword(newPassword);
            }
        }
        if (!found) {
            throw new UserNotFoundException();
        }
    }
}
