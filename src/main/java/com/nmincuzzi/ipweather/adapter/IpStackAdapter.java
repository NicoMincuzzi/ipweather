package com.nmincuzzi.ipweather.adapter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nmincuzzi.ipweather.model.IpStackModel;
import com.nmincuzzi.ipweather.expection.GenericError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class IpStackAdapter {

    public IpStackModel execute(String ipAddress) throws GenericError {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/" + ipAddress + "?" + "access_key=";
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(url, ObjectNode.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return extracted(response.getBody());
        }
        throw new GenericError();
    }

    private IpStackModel extracted(ObjectNode response) {
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
