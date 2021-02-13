package com.nmincuzzi.ipweather.representation;

import lombok.Data;

@Data
public class LocationRepresentation {

    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private String zip;
    private String latitude;
    private String longitude;
}
