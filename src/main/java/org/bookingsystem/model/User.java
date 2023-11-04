package org.bookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User class
 *
 * @author HninHninToe
 */
@Entity
public class User {
    /**
     * ID
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * Username
     */
    private String username;


    /**
     * user password
     */
    private String password;


    /**
     * Email
     */
    private String email;

    /**
     * phone number
     */
    private String phoneNumber;

    /**
     * address
     */
    private String address;

    /**
     * credit of user
     */
    private int credit;

    /**
     * Getter for ID
     *
     * @return ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Setter for ID
     *
     * @param userId ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Getter for username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Setter for username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for phone number
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phone number
     *
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Getter for address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for address
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for credit
     *
     * @return credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Setter for credit
     *
     * @param credit credit
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, "password");
    }


}

