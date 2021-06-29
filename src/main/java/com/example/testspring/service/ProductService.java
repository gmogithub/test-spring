package com.example.testspring.service;

import com.example.testspring.connector.service.IProductConnectorService;
import com.example.testspring.payload.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final IProductConnectorService iProductConnectorService;

    @Autowired
    public ProductService(IProductConnectorService iProductConnectorService) {
        this.iProductConnectorService = iProductConnectorService;
    }

    public List<ProductResponse> getProductResponses() {
        return iProductConnectorService.getProductResponse();
    }
}
