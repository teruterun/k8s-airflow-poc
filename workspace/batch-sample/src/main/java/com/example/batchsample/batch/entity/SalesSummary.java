package com.example.batchsample.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesSummary {
    private int salesId;
    private String productName;
    private int quantity;
    private int price;
    private String date;
    private int totalAmount;
}
