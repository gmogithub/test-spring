package com.example.testspring.connector.payload;

public class ProductExternalResponse {
    private Long id;
    private String ean;
    private String name;
    private Double weight;
    private String description;
    private Double price;
    private boolean assembled;
    private DimensionExternalResponse dimensionResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAssembled() {
        return assembled;
    }

    public void setAssembled(boolean assembled) {
        this.assembled = assembled;
    }

    public DimensionExternalResponse getDimensionResponse() {
        return dimensionResponse;
    }

    public void setDimensionResponse(DimensionExternalResponse dimensionResponse) {
        this.dimensionResponse = dimensionResponse;
    }
}
