package org.bookingsystem.infrastructure.repository;

import org.bookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository class
 *
 * @author HninHninToe
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find user by email
     *
     * @param email target email
     * @return User
     */
    User findUserByEmail(String email);
}
