package com.example.testspring.connector.service;

import com.example.testspring.payload.DimensionResponse;

import com.example.testspring.payload.ProductResponse;
import com.example.testspring.connector.payload.DimensionExternalResponse;
import com.example.testspring.connector.payload.ProductExternalResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductConnectorService implements IProductConnectorService {

    private List<ProductExternalResponse> getProductExternalResponses() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:8080/external/products", String.class);


        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductExternalResponse> response = new ArrayList<>();
        try {
            response = objectMapper.readValue(responseEntity.getBody(), new TypeReference<>() {
            });


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }

    private ProductResponse mapToProductResponses(ProductExternalResponse productExternalResponse) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productExternalResponse.getId());
        productResponse.setCode(productExternalResponse.getEan());
        productResponse.setName(productExternalResponse.getName());
        productResponse.setWeight(productExternalResponse.getWeight());
        productResponse.setDescription(productExternalResponse.getDescription());
        productResponse.setPrice(productExternalResponse.getPrice());
        productResponse.setAssembled(productExternalResponse.isAssembled());
        productResponse.setDimensionResponse(mapToDimensionResponse(productExternalResponse.getDimensionResponse()));
        return productResponse;
    }

    private DimensionResponse mapToDimensionResponse(DimensionExternalResponse dimensionExternalResponse) {
        DimensionResponse dimensionResponse = new DimensionResponse();
        dimensionResponse.setWidth(dimensionExternalResponse.getWidth());
        dimensionResponse.setHeight(dimensionExternalResponse.getHeight());
        dimensionResponse.setDepth(dimensionExternalResponse.getDepth());
        return dimensionResponse;
    }

    @Override
    public List<ProductResponse> getProductResponse() {
        List<ProductExternalResponse> productExternalResponses = getProductExternalResponses();
        return productExternalResponses.stream().map(this::mapToProductResponses).collect(Collectors.toList());
    }
}
