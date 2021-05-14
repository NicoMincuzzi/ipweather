package com.nmincuzzi.ipweather.service;

import com.nmincuzzi.ipweather.adapter.IpStackAdapter;
import com.nmincuzzi.ipweather.expection.GenericError;
import com.nmincuzzi.ipweather.model.IpStackModel;
import com.nmincuzzi.ipweather.representation.LocationRepresentation;
import org.springframework.stereotype.Service;

import static com.nmincuzzi.ipweather.converter.ConverterKt.toLocationRepresentation;

@Service
public class LocationService {

    private final IpStackAdapter ipStackAdapter;

    public LocationService(IpStackAdapter ipStackAdapter) {
        this.ipStackAdapter = ipStackAdapter;
    }

    public String retrieveIpAddress(String xForwardedForHeader, String remoteAddr) {
        String ipAddress = xForwardedForHeader;
        if (ipAddress == null || ipAddress.isBlank()) {
            ipAddress = remoteAddr;
        }
        return ipAddress;
    }

    public LocationRepresentation retrieveLocation(String ipAddress) throws GenericError {
        IpStackModel ipStackModel = ipStackAdapter.execute(ipAddress);
        return toLocationRepresentation(ipStackModel);
    }
}
