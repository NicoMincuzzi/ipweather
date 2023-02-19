package com.nmincuzzi.ipweather.infrastructure;

import com.nmincuzzi.ipweather.domain.GenericError;
import com.nmincuzzi.ipweather.usecase.GetLocation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
class LocationController {
    private final GetLocation location;

    public LocationController(GetLocation location) {
        this.location = location;
    }

    @GetMapping(value = "/location", produces = APPLICATION_JSON_VALUE)
    public LocationResponse location(HttpServletRequest request) throws GenericError {

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