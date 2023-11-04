package org.bookingsystem.domain.service;

import org.bookingsystem.infrastructure.repository.PackageRepository;
import org.bookingsystem.model.Package;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service class
 *
 * @author HninHninToe
 */
@Service
public class PackageService {

    /**
     * Package repository
     */
    PackageRepository packageRepository;

    /**
     * Constructor
     *
     * @param packageRepository user repository
     */
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    /**
     * get all package
     *
     * @return package list
     */
    public List<Package> getAllPackages() {
        return this.packageRepository.findAll();
    }

    /**
     * get all package
     *
     * @param availableCountryId target country id
     * @return package list
     */
    public List<Package> findByAvailableCountryId(int availableCountryId) {
        return this.packageRepository.findByAvailableCountryId(availableCountryId);
    }
}
