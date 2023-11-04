package org.bookingsystem.web.controller;

import org.bookingsystem.domain.service.PackageService;
import org.bookingsystem.domain.service.UserService;
import org.bookingsystem.model.Package;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User management controller
 *
 * @author HninHninToe
 */
@RestController
@RequestMapping("/package")
public class PackageController {

    /**
     * package service
     */
    PackageService packageService;

    /**
     * Constructor
     *
     * @param packageService package service
     */
    public PackageController(UserService packageService) {
        this.packageService = this.packageService;
    }

    /**
     * Show book detail screen
     *
     * @return package list
     */
    @GetMapping("/list")
    public List<Package> listPackage() {
        List<Package> packageList = this.packageService.getAllPackages();
        return packageList;
    }

    /**
     * Show book detail screen
     *
     * @param countryId target country id
     * @return package list
     */
    @GetMapping(value = "/list", params = "country-id")
    public List<Package> filterPackage(@RequestParam(name = "country-id") int countryId) {
        List<Package> packageList = this.packageService.findByAvailableCountryId(countryId);
        return packageList;
    }


}
