package org.bookingsystem.domain.service;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import com.github.database.rider.junit5.api.DBRider;
import org.bookingsystem.BookingSystemApplication;
import org.bookingsystem.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Genre service test class
 *
 * @author HninHninToe
 */
@SpringBootTest(classes = BookingSystemApplication.class)
@ExtendWith(DBUnitExtension.class)
@ActiveProfiles("test")
@DBRider
@DBUnit(qualifiedTableNames = true)
public class UserServiceTest {

    /**
     * User repository
     */
    @Autowired
    UserService userService;

    @BeforeEach
    @DataSet(value = {"bookingsystemDataset.xlsx"}, cleanAfter = true)
    public void before() {
    }

    /**
     * Test findByEmail method
     */
    @Test
    void findByEmail_OK() {
        // prepare

        // execute
        User user = userService.findByEmail("john.doe@example.com");

        // assert
        assertEquals(1, user.getUserId());
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("555-123-4567", user.getPhoneNumber());
        assertEquals(1000, user.getCredit());
    }

    /**
     * Test findByEmail method
     */
    @Test
    void findByEmail_not_exist_user() {
        // prepare

        // execute, assert
        assertThrows(ArithmeticException.class, () -> {
            userService.findByEmail("no-exist@example.com");
        });
    }
}
