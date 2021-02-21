package com.nmincuzzi.ipweather.controller;

import com.nmincuzzi.ipweather.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public void location(HttpServletRequest request) {

        String ipAddress = locationService.retrieveIpAddress(
                request.getHeader("X-FORWARDED-FOR"),
                request.getRemoteAddr()
        );

        locationService.retrieveLocation(ipAddress);
    }
}