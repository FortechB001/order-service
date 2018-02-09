package com.fortech.orderservice.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
@Data
@RequiredArgsConstructor
public class Order {

    @Id
    private String id;

    @NonNull
    private String productId;

    @NonNull
    private Integer quantity;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date orderDate;

    public Order() {
        if (orderDate == null) {
            orderDate = new Date();
        }
    }
}
