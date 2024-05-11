package com.onlineshop.notificationservice.elasticsearch.dto;

import org.springframework.data.elasticsearch.annotations.Field;

public class ProductDto {
    private String id;
    @Field("whishlist_item_id")
    private String whishlistItemId;
    @Field("product_id")
    private String productId;
}
