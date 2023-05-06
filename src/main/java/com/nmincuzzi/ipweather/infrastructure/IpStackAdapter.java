package com.nmincuzzi.ipweather.infrastructure;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nmincuzzi.ipweather.domain.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;

import static com.nmincuzzi.ipweather.domain.Locale.to;

@Component
public class IpStackAdapter {

    private final Logger log = LoggerFactory.getLogger(IpStackAdapter.class);

    private final RestTemplate restTemplate;
    private final String host;
    private final String accessKey;

    public IpStackAdapter(RestTemplate restTemplate,
                          @Value("${ipstack.url}") String host,
                          @Value("${ipstack.access_key}") String accessKey) {
        this.restTemplate = restTemplate;
        this.host = host;
        this.accessKey = accessKey;
    }

    public Locale execute(String ipAddress) {
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(buildURI(ipAddress), ObjectNode.class);
        log.info("Response of IpStack service ip_address: {} response: {}", ipAddress, response.getBody());

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return to(response.getBody());
        }
        throw new RuntimeException();
    }

    private URI buildURI(String ipAddress) {
        try {
            URL url = new URL(host);

            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                    .scheme(url.getProtocol())
                    .host(url.getHost())
                    .path(ipAddress)
                    .queryParam("access_key", accessKey);
            if (url.getPort() != 0)
                uriComponentsBuilder.port(url.getPort());

            return uriComponentsBuilder.build().toUri();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
