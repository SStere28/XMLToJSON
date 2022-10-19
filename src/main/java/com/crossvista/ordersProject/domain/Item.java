package com.crossvista.ordersProject.domain;

import java.util.Date;
import java.util.Objects;

public class Item {
    private String partNumber;
    private String productName;
    private int quantity;
    private double price;
    private String comment;
    private Date shipDate;

    public Item() {

    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getQuantity() == item.getQuantity() && Double.compare(item.getPrice(), getPrice()) == 0 && Objects.equals(getPartNumber(), item.getPartNumber()) && Objects.equals(getProductName(), item.getProductName()) && Objects.equals(getComment(), item.getComment()) && Objects.equals(getShipDate(), item.getShipDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartNumber(), getProductName(), getQuantity(), getPrice(), getComment(), getShipDate());
    }

    @Override
    public String toString() {
        return "Item{" +
                "partNumber='" + partNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", shipDate=" + shipDate +
                '}';
    }
}
