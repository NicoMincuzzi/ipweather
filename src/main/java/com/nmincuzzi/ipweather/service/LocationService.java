package com.nmincuzzi.ipweather.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LocationService {

    public String retrieveIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress.isBlank()) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public void retrieveLocation(String ipAddress) {
    }
}
