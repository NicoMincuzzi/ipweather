package com.nmincuzzi.ipweather.adapter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nmincuzzi.ipweather.expection.GenericError;
import com.nmincuzzi.ipweather.model.IpStackModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class IpStackAdapter {

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

    public IpStackModel execute(String ipAddress) throws GenericError {
        String url = host + ipAddress + "?" + "access_key=" + accessKey;
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(url, ObjectNode.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return toModel(response.getBody());
        }
        throw new GenericError();
    }

    private IpStackModel toModel(ObjectNode response) {
        return new IpStackModel(
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
