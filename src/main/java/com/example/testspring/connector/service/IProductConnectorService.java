package com.example.testspring.connector.service;

import com.example.testspring.payload.ProductResponse;

import java.util.List;

public interface IProductConnectorService {
    List<ProductResponse> getProductResponse();
}
