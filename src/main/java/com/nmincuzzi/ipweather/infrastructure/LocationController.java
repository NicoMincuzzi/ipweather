package com.nmincuzzi.ipweather.infrastructure;

import com.nmincuzzi.ipweather.domain.GuestIpAddress;
import com.nmincuzzi.ipweather.usecase.GetLocationByIpAddress;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nmincuzzi.ipweather.domain.GuestIpAddress.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
class LocationController {
    private final GetLocationByIpAddress getLocationByIpAddress;

    public LocationController(GetLocationByIpAddress getLocationByIpAddress) {
        this.getLocationByIpAddress = getLocationByIpAddress;
    }

    @GetMapping(value = "/location", produces = APPLICATION_JSON_VALUE)
    public LocationResponse location(HttpServletRequest request) {
        GuestIpAddress guestIpAddress = fromHeader(request.getHeader("X-FORWARDED-FOR"));
        return getLocationByIpAddress.execute(guestIpAddress);
    }
}