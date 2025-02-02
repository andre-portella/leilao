package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Auction {
    private int bidId;
    private int productId;
    private int userId;
    private BigDecimal bidValue;
    private Timestamp bidTime;

    public Auction(int bidId, int productId, int userId, BigDecimal bidValue, Timestamp bidTime) {
        this.bidId = bidId;
        this.productId = productId;
        this.userId = userId;
        this.bidValue = bidValue;
        this.bidTime = bidTime;
    }

    // Getters e Setters
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getBidValue() {
        return bidValue;
    }

    public void setBidValue(BigDecimal bidValue) {
        this.bidValue = bidValue;
    }

    public Timestamp getBidTime() {
        return bidTime;
    }

    public void setBidTime(Timestamp bidTime) {
        this.bidTime = bidTime;
    }
}