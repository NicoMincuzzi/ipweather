package com.nmincuzzi.ipweather.infrastructure;

public class LocationRepresentation {
    private final String countryCode;
    private final String countryName;
    private final String regionCode;
    private final String regionName;
    private String city;
    private final String zip;
    private final String latitude;
    private final String longitude;

    public LocationRepresentation(String countryCode, String countryName, String regionCode, String regionName, String city, String zip, String latitude, String longitude) {
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
}
