package ru.shaitanshamma.flow.order;

import lombok.Data;

@Data
public class OrderModel {
    private AdressInfo adressInfo;
    private BasicOrderInfo basicOrderInfo;
}
