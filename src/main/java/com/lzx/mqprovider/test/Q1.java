package com.lzx.mqprovider.test;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String []args){
        Long totalAmount = 30L;
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().unitPrice(10L).quantity(2).build());
        productList.add(Product.builder().unitPrice(7L).quantity(3).build());
        productList.add(Product.builder().unitPrice(8L).quantity(0).build());
        Long oldTotalAmount = productList.stream().mapToLong(product -> product.getQuantity()*product.getUnitPrice()).sum();
        productList.forEach(product -> {
            Long amount = new BigDecimal(totalAmount*product.getQuantity()*product.getUnitPrice()).divide(new BigDecimal(oldTotalAmount),8,RoundingMode.HALF_EVEN).longValue();
            product.setAmount(amount);
        });
        productList.forEach(product -> {
            System.out.println("unitPrice:"+product.getUnitPrice()+",quantity:"+product.getQuantity()+",amount:"+product.getAmount());
        });
    }

    @Data
    @Builder
    static class Product{
        /**
         *产品单价
         */
        private Long unitPrice;
        /**
         *产品数量
         */
        private int quantity;
        /**
         *产品分摊所得金额
         */
        private Long amount;

    }
}


