package com.toy.itx_subway;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WebClientUtil {
    private static DefaultUriBuilderFactory factory;
    private final String baseURL = "http://swopenapi.seoul.go.kr/api/subway";
    private final String subwayApiKey = "5a4369665568616e35367070464f47";

    public WebClientUtil() {
        this.factory = new DefaultUriBuilderFactory(baseURL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
    }

    public String getApiResponse(String station){
        String encodeStation = URLEncoder.encode(station, StandardCharsets.UTF_8);

        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .uriBuilderFactory(factory).baseUrl(baseURL).build();

        String response = webClient.get()
                .uri(uriBuilder ->
                uriBuilder.path("/" + subwayApiKey + "/json/realtimeStationArrival/0/5/"+encodeStation).build())
                .retrieve().bodyToMono(String.class).block();

        return response;
    }
}
