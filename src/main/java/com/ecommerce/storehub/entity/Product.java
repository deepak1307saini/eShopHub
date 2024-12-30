package com.ecommerce.storehub.entity;

import com.ecommerce.storehub.util.DBConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = DBConstants.TABLE_PRODUCTS)
public class Product extends BaseEntity implements Serializable {
    @Id
    @Column(name = DBConstants.COLUMN_PRODUCT_ID, nullable = false)
    private String productId;

    @Column(name = DBConstants.COLUMN_SHOP_ID, nullable = false)
    private String shopId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_SHOP_ID, insertable = false, updatable = false)
    private Shop shop;

    @Column(name = DBConstants.COLUMN_PRODUCT_CATEGORY_ID, nullable = false)
    private String productCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_PRODUCT_CATEGORY_ID, insertable = false, updatable = false)
    private ProductCategory productCategory;

    @Column(name = DBConstants.COLUMN_PRODUCT_NAME, nullable = false)
    private String productName;

    @Column(name = DBConstants.COLUMN_PRICE, nullable = false)
    private Double price;

    @Column(name = DBConstants.COLUMN_STOCK_QUANTITY, nullable = false)
    private Integer stockQuantity;

    @Column(name = DBConstants.COLUMN_STATUS)
    private String status;

    @Override
    protected String getId() {
        return this.productId;
    }

    @Override
    protected void setId(String id) {
        this.productId = id;
    }
}
