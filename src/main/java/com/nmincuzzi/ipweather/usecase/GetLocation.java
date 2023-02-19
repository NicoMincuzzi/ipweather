package com.nmincuzzi.ipweather.usecase;

import com.nmincuzzi.ipweather.infrastructure.IpStackAdapter;
import com.nmincuzzi.ipweather.domain.Locale;
import com.nmincuzzi.ipweather.domain.GenericError;
import com.nmincuzzi.ipweather.infrastructure.LocationResponse;
import org.springframework.stereotype.Component;

import static com.nmincuzzi.ipweather.converter.ConverterKt.toLocationRepresentation;

@Component
public class GetLocation {
    private final IpStackAdapter ipStackAdapter;

    public GetLocation(IpStackAdapter ipStackAdapter) {
        this.ipStackAdapter = ipStackAdapter;
    }

    public LocationResponse by(String ipAddress) throws GenericError {
        Locale locale = ipStackAdapter.execute(ipAddress);
        return toLocationRepresentation(locale);
    }
}
