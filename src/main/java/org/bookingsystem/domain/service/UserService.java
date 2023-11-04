package org.bookingsystem.domain.service;

import org.bookingsystem.exception.UserNotFoundException;
import org.bookingsystem.infrastructure.repository.UserRepository;
import org.bookingsystem.logging.BookingSystemLogger;
import org.bookingsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * User service class
 *
 * @author HninHninToe
 */
@Service
public class UserService {

    /**
     * logging
     */
    private static final BookingSystemLogger logger = BookingSystemLogger.getLogger(UserService.class);

    /**
     * Password encoder
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Password reset service
     */
    PasswordResetService passwordResetService;

    /**
     * User repository
     */
    UserRepository userRepository;

    /**
     * Constructor
     *
     * @param passwordResetService passwordResetService
     * @param userRepository       user repository
     */
    public UserService(PasswordResetService passwordResetService, UserRepository userRepository) {
        this.passwordResetService = passwordResetService;
        this.userRepository = userRepository;
    }


    /**
     * Find the user with email
     *
     * @param email target email
     * @return user
     */
    public User findByEmail(String email) {
        User user = this.userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("system.error.usernotfoundbymail", email);
        }
        return user;
    }

    /**
     * Update user password
     *
     * @param userId      target user ID
     * @param newPassword target password
     * @return user
     */
    public User updateUserPassword(Long userId, String newPassword) {
        // Retrieve the user by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("system.error.usernotfoundbyid", userId));

        // Update the user's password
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        logger.info("system.info.update", user);
        // Save the updated user entity
        return userRepository.save(user);
    }

    /**
     * Reset user password
     *
     * @param email target email
     */
    public void resetUserPassword(String email) {
        // Retrieve the user by ID
        User user = userRepository.findUserByEmail(email);

        // TODO modify token to include target user info
        // this token will be just for mock. In actual system, token should include target user info
        String token = UUID.randomUUID().toString();
        String passwordResetUrl = this.passwordResetService.generateResetPasswordUrl(token);
        this.sendPasswordResetMail(passwordResetUrl);
    }

    /**
     * Mock method for sending password reset URL
     *
     * @param passwordResetUrl target passwordResetUrl
     */
    public void sendPasswordResetMail(String passwordResetUrl) {
        logger.info("system.info.mailsend.passwordreseturl");
    }
}
