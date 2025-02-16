package com.example.batchsample.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesReport {
    private String productName; // 商品名
    private int totalSales;     // 合計売上金額
}
