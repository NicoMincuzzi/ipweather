package com.nmincuzzi.ipweather.infrastructure;

import com.nmincuzzi.ipweather.usecase.GetLocation;
import com.nmincuzzi.ipweather.domain.GenericError;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
class LocationResource {
    private final GetLocation location;

    public LocationResource(GetLocation location) {
        this.location = location;
    }

    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationRepresentation location(HttpServletRequest request) throws GenericError {

        String ipAddress = retrieveIpAddress(request.getHeader("X-FORWARDED-FOR"), request.getRemoteAddr());
        return location.by(ipAddress);
    }

    private String retrieveIpAddress(String xForwardedForHeader, String remoteAddress) {
        String ipAddress = xForwardedForHeader;
        if (ipAddress == null || ipAddress.isBlank()) {
            ipAddress = remoteAddress;
        }
        return ipAddress;
    }
}