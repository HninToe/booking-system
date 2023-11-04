package org.bookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * Package class
 *
 * @author HninHninToe
 */
@Entity
public class Package {
    /**
     * ID
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * credit(s)
     */
    private int credit;


    /**
     * price (e.g MMK 100,000, $100)
     */
    private String price;


    /**
     * status(0: expired, 1: available)
     */
    private int status;

    /**
     * Available country id
     */
    private int availableCountryId;

    /**
     * Expired date
     */
    private LocalDate expiredDate;

    /**
     * Getter for ID
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * Getter for price
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Setter for price
     *
     * @param price price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Getter for status
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter for status
     *
     * @param status status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Getter for available country ID
     *
     * @return available country ID
     */
    public int getAvailableCountryId() {
        return availableCountryId;
    }

    /**
     * Setter for available country ID
     *
     * @param availableCountryId available country ID
     */
    public void setAvailableCountryId(int availableCountryId) {
        this.availableCountryId = availableCountryId;
    }

    /**
     * Getter for expired date
     *
     * @return expired date
     */
    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    /**
     * Setter for expired date
     *
     * @param expiredDate expired date
     */
    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }


}

