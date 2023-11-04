package org.bookingsystem.infrastructure.repository;

import org.bookingsystem.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Package repository class
 *
 * @author HninHninToe
 */
public interface PackageRepository extends JpaRepository<Package, Long> {

    /**
     * Find package list of target country
     *
     * @param availableCountryId available country id
     * @return package list
     */
    List<Package> findByAvailableCountryId(int availableCountryId);

}
