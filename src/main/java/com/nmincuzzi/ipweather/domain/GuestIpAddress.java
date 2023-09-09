package com.nmincuzzi.ipweather.domain;

import static io.micrometer.common.util.StringUtils.isBlank;

public record GuestIpAddress(String value) {

    public static GuestIpAddress fromHeader(String xForwardedForHeader) {
        String ipAddress = xForwardedForHeader.split(",")[0];
        return new GuestIpAddress(isBlank(ipAddress) ? "" : ipAddress);
    }
}
