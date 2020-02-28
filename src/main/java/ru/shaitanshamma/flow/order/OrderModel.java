package ru.shaitanshamma.flow.order;

import java.io.Serializable;


public class OrderModel implements Serializable {
    private AddressInfo addressInfo;
    private BasicOrderInfo basicOrderInfo;

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public BasicOrderInfo getBasicOrderInfo() {
        return basicOrderInfo;
    }

    public void setBasicOrderInfo(BasicOrderInfo basicOrderInfo) {
        this.basicOrderInfo = basicOrderInfo;
    }
}

