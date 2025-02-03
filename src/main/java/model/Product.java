package model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String name;
    private BigDecimal minBid;
    private String description;
    private String imageUrl;

    // public Product(int productId, String name, BigDecimal minBid, String description, String imageUrl){
    //     this.productId = productId;
    //     this.name = name;
    //     this.minBid = minBid;
    //     this.description = description;
    //     this.imageUrl = imageUrl;
    // }

    // Getters e Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinBid() {
        return minBid;
    }

    public void setMinBid(BigDecimal minBid) {
        this.minBid = minBid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}