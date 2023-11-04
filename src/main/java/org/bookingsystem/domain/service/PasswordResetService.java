package org.bookingsystem.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Password reset service class
 *
 * @author HninHninToe
 */
@Service
public class PasswordResetService {
    @Value("${bookingsystem.system.reset-password.base-url}")
    private String resetPasswordBaseUrl; // A property to specify the base URL

    /**
     * Constructor
     */
    public PasswordResetService() {
    }

    /**
     * Generate URL to reset password
     *
     * @param token token
     * @return reset password URL
     */
    public String generateResetPasswordUrl(String token) {
        return resetPasswordBaseUrl + "/reset-password?token=" + token;
    }
}