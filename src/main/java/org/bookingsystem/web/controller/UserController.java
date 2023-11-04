package org.bookingsystem.web.controller;

import org.bookingsystem.domain.service.UserService;
import org.bookingsystem.exception.UserNotFoundException;
import org.bookingsystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User management controller
 *
 * @author HninHninToe
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * user service
     */
    UserService userService;

    /**
     * Constructor
     *
     * @param userService user service
     */
    public UserController(UserService userService) {
        this.userService = this.userService;
    }


    /**
     * Show user detail info
     *
     * @param email target user's email
     * @return user
     */
    @GetMapping("/detail")
    public User getUserDetail(@RequestParam(name = "email") String email) {
        User user = this.userService.findByEmail(email);
        return user;
    }

    /**
     * Reset user password
     *
     * @param userId      target user ID
     * @param newPassword new password
     * @return user with updated password
     */
    @PostMapping("/{userId}/update-password")
    public User updateUserPassword(@PathVariable Long userId, @RequestBody String newPassword) {
        return userService.updateUserPassword(userId, newPassword);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetUserPassword(@RequestParam String email) {
        try {
            this.userService.resetUserPassword(email);
            return ResponseEntity.ok("Send email for resetting password.");
        } catch (UserNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

}
