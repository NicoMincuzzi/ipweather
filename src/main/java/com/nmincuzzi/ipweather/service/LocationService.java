package com.nmincuzzi.ipweather.service;

import com.nmincuzzi.ipweather.adapter.IpStackAdapter;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final IpStackAdapter ipStackAdapter;

    public LocationService(IpStackAdapter ipStackAdapter) {
        this.ipStackAdapter = ipStackAdapter;
    }

    public String retrieveIpAddress(String xForwardedForHeader, String remoteAddr) {
        String ipAddress = xForwardedForHeader;
        if (ipAddress.isBlank()) {
            ipAddress = remoteAddr;
        }
        return ipAddress;
    }

    public void retrieveLocation(String ipAddress) {
        ipStackAdapter.execute(ipAddress);
    }
}
