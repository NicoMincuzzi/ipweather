package com.nmincuzzi.ipweather.infrastructure;

import com.nmincuzzi.ipweather.usecase.GetLocationByIpAddress;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
class LocationController {
    private final GetLocationByIpAddress location;

    public LocationController(GetLocationByIpAddress location) {
        this.location = location;
    }

    @GetMapping(value = "/location", produces = APPLICATION_JSON_VALUE)
    public LocationResponse location(HttpServletRequest request) {

        String ipAddress = retrieveIpAddress(request.getHeader("X-FORWARDED-FOR"));
        return location.execute(ipAddress);
    }

    private String retrieveIpAddress(String xForwardedForHeader) {
        String ipAddress = xForwardedForHeader.split(",")[0];
        if (!StringUtils.isBlank(ipAddress)) {
            return ipAddress;
        }
        return "";
    }
}