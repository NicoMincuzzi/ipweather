package com.nmincuzzi.ipweather.representation;

import lombok.Data;

@Data
public class LocationRepresentation {

    private String countryCode;
    private String countryName;
    private String regionCode;
    private String regionName;
    private String city;
    private String zip;
    private String latitude;
    private String longitude;
}
