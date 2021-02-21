package com.nmincuzzi.ipweather.adapter;

import com.nmincuzzi.ipweather.model.IpStackModel;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IpStackAdapter {

    public IpStackModel execute(String ipAddress) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        String fooResourceUrl = "http://localhost:8080/" + ipAddress + "?" + "access_key=";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        return new IpStackModel();
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }

}
