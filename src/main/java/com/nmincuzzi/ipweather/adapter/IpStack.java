package com.nmincuzzi.ipweather.adapter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nmincuzzi.ipweather.expection.GenericError;
import com.nmincuzzi.ipweather.domain.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.nmincuzzi.ipweather.domain.Locale.to;

@Slf4j
@Component
public class IpStack {
    private final RestTemplate restTemplate;
    private final String host;
    private final String accessKey;

    public IpStack(RestTemplate restTemplate,
                   @Value("${ipstack.url}") String host,
                   @Value("${ipstack.access_key}") String accessKey) {
        this.restTemplate = restTemplate;
        this.host = host;
        this.accessKey = accessKey;
    }

    public Locale execute(String ipAddress) throws GenericError {
        String url = host + ipAddress + "?" + "access_key=" + accessKey;
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(url, ObjectNode.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return to(response.getBody());
        }
        throw new GenericError();
    }
}
