package com.nmincuzzi.ipweather.controller;

import com.nmincuzzi.ipweather.representation.LocationRepresentation;
import com.nmincuzzi.ipweather.expection.GenericError;
import com.nmincuzzi.ipweather.service.LocationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationRepresentation location(HttpServletRequest request) throws GenericError {

        String ipAddress = locationService.retrieveIpAddress(
                request.getHeader("X-FORWARDED-FOR"),
                request.getRemoteAddr()
        );

        return locationService.retrieveLocation(ipAddress);
    }
}