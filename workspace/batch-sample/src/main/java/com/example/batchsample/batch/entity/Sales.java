package com.example.batchsample.batch.entity;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    private int salesId;      // 売上 ID
    private int productId;    // 商品 ID
    private int quantity;     // 売れた個数
    private LocalDate date;   // 売上日
}

