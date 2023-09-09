package com.nmincuzzi.ipweather.usecase;

import com.nmincuzzi.ipweather.domain.GuestIpAddress;
import com.nmincuzzi.ipweather.domain.Locale;
import com.nmincuzzi.ipweather.infrastructure.IpStackAdapter;
import com.nmincuzzi.ipweather.infrastructure.LocationResponse;
import org.springframework.stereotype.Component;

import static com.nmincuzzi.ipweather.domain.ConverterKt.toLocationRepresentation;

@Component
public class GetLocationByIpAddress {
    private final IpStackAdapter ipStackAdapter;

    public GetLocationByIpAddress(IpStackAdapter ipStackAdapter) {
        this.ipStackAdapter = ipStackAdapter;
    }

    public LocationResponse execute(GuestIpAddress guestIpAddress) {
        try {
            Locale locale = ipStackAdapter.execute(guestIpAddress);
            return toLocationRepresentation(locale);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
