package com.nmincuzzi.ipweather.application;

import com.nmincuzzi.ipweather.adapter.IpStack;
import com.nmincuzzi.ipweather.domain.Locale;
import com.nmincuzzi.ipweather.expection.GenericError;
import com.nmincuzzi.ipweather.infrastructure.LocationRepresentation;
import org.springframework.stereotype.Component;

import static com.nmincuzzi.ipweather.converter.ConverterKt.toLocationRepresentation;

@Component
public class GetLocation {
    private final IpStack ipStack;

    public GetLocation(IpStack ipStack) {
        this.ipStack = ipStack;
    }

    public LocationRepresentation by(String ipAddress) throws GenericError {
        Locale locale = ipStack.execute(ipAddress);
        return toLocationRepresentation(locale);
    }
}
