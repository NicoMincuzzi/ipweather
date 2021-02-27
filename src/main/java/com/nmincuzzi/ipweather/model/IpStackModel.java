package com.nmincuzzi.ipweather.model;

public class IpStackModel {

    private String countryCode;

    private String countryName;

    private String regionCode;

    private String regionName;

    private String city;

    private String zip;

    private String latitude;

    private String longitude;

    public IpStackModel(String countryCode,
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

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
