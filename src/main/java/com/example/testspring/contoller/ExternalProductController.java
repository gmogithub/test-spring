package com.example.testspring.contoller;

import com.example.testspring.connector.payload.DimensionExternalResponse;
import com.example.testspring.connector.payload.ProductExternalResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExternalProductController {
    @GetMapping("/external/products")
    public List<ProductExternalResponse> getProductResponse() {
        List<ProductExternalResponse> list = new ArrayList<>();

        ProductExternalResponse productResponse = new ProductExternalResponse();
        productResponse.setId(45L);
        productResponse.setEan("4545");
        productResponse.setName("Test");
        productResponse.setWeight(10.5);
        productResponse.setDescription("Json");
        productResponse.setPrice(100.00);
        productResponse.setAssembled(false);
        DimensionExternalResponse dimensionResponse = new DimensionExternalResponse();
        dimensionResponse.setWidth(10.0D);
        dimensionResponse.setHeight(10.0D);
        dimensionResponse.setDepth(10.0D);

        productResponse.setDimensionResponse(dimensionResponse);

        list.add(productResponse);


        ProductExternalResponse productResponse2 = new ProductExternalResponse();
        productResponse2.setId(5L);
        productResponse2.setEan("454dddd5");
        productResponse2.setName("Tesdddddt");
        productResponse2.setWeight(10.5);
        productResponse2.setDescription("Json");
        productResponse2.setPrice(100.00);
        productResponse2.setAssembled(false);
        DimensionExternalResponse dimensionResponse2 = new DimensionExternalResponse();
        dimensionResponse2.setWidth(100.0D);
        dimensionResponse2.setHeight(100.0D);
        dimensionResponse2.setDepth(100.0D);
        productResponse2.setDimensionResponse(dimensionResponse2);
        list.add(productResponse2);
        return list;
    }
}
