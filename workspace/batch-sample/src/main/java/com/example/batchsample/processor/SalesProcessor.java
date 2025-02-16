package com.example.batchsample.processor;

import com.example.batchsample.batch.entity.Product;
import com.example.batchsample.batch.entity.Sales;
import com.example.batchsample.batch.entity.SalesSummary;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.batch.core.configuration.annotation.StepScope;

import java.util.HashMap;
import java.util.Map;

@StepScope
public class SalesProcessor implements ItemProcessor<Sales, SalesSummary> {

    private final Map<Long, Product> productMap = new HashMap<>();

    public SalesProcessor(@Value("#{jobParameters['productData']}") String productData) {
        // jobParameter から productData のファイル名を取得（将来的に拡張しやすい）
        System.out.println("Loading product data from: " + productData);
    }

    @Override
    public SalesSummary process(Sales sales) throws Exception {
    	System.out.println("イエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエエイ");
    	System.out.println(sales);
        Product product = productMap.get(sales.getProductId());
        if (product == null) {
            throw new IllegalArgumentException("商品情報が見つかりません: " + sales.getProductId());
        }
        return SalesSummary.builder()
                .salesId(sales.getSalesId())
                .date(sales.getDate().toString())
                .productName(product.getName())
                .quantity(sales.getQuantity())
                .price(product.getPrice())
                .totalAmount(sales.getQuantity() * product.getPrice())
                .build();
    }
}
