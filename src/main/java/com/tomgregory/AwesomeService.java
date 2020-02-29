package com.tomgregory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class AwesomeService {
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getWebPage() throws IOException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl("http://get-simple.info/api/start/"));
        String response =  request.execute().parseAsString();

        return objectMapper.readValue(response, JsonNode.class);
    }
}
