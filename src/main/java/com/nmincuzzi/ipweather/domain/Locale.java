package com.nmincuzzi.ipweather.domain;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Locale {
    private final String countryCode;
    private final String countryName;
    private final String regionCode;
    private final String regionName;
    private String city;
    private final String zip;
    private final String latitude;
    private final String longitude;

    public Locale(String countryCode,
                  String countryName,
                  String regionCode,
                  String regionName,
                  String city,
                  String zip,
                  String latitude,
                  String longitude
    ) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.city = city;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public static Locale to(ObjectNode response) {
        return new Locale(
                response.get("country_code").toString(),
                response.get("country_name").toString(),
                response.get("region_code").toString(),
                response.get("region_name").toString(),
                response.get("city").toString(),
                response.get("zip").toString(),
                response.get("latitude").toString(),
                response.get("longitude").toString());
    }
}
