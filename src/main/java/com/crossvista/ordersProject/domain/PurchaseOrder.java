package com.crossvista.ordersProject.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PurchaseOrder {
    private long orderNumber;
    private Date orderDate;
    private Adress shippingAdress;
    private Adress billingAdress;
    private String deliveryNotes;
    private List<Item> items;

    public PurchaseOrder() {
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Adress getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(Adress shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public Adress getBillingAdress() {
        return billingAdress;
    }

    public void setBillingAdress(Adress billingAdress) {
        this.billingAdress = billingAdress;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrder)) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return getOrderNumber() == that.getOrderNumber() && Objects.equals(getOrderDate(), that.getOrderDate()) && Objects.equals(getShippingAdress(), that.getShippingAdress()) && Objects.equals(getBillingAdress(), that.getBillingAdress()) && Objects.equals(getDeliveryNotes(), that.getDeliveryNotes()) && Objects.equals(getItems(), that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getOrderDate(), getShippingAdress(), getBillingAdress(), getDeliveryNotes(), getItems());
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", shippingAdress=" + shippingAdress +
                ", billingAdress=" + billingAdress +
                ", deliveryNotes='" + deliveryNotes + '\'' +
                ", items=" + items +
                '}';
    }
}
