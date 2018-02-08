package com.fortech.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private String id;

    @NonNull
    private String productId;

    @NonNull
    private String quantity;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date orderDate;

}
