package com.ecommerce.storehub.entity;

import com.ecommerce.storehub.util.DBConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = DBConstants.TABLE_PRODUCT_CATEGORIES)
public class ProductCategory extends BaseEntity implements Serializable {
    @Id
    @Column(name = DBConstants.COLUMN_PRODUCT_CATEGORY_ID, nullable = false)
    private String productCategoryId;

    @Column(name = DBConstants.COLUMN_SHOP_ID, nullable = false)
    private String shopId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_SHOP_ID, insertable = false, updatable = false)
    private Shop shop;

    @Column(name = DBConstants.COLUMN_CATEGORY_NAME, nullable = false)
    private String categoryName;

    @Column(name = DBConstants.COLUMN_CATEGORY_DESCRIPTION)
    private String categoryDescription;

    @Column(name = DBConstants.COLUMN_ORDER_PRIORITY)
    private Integer orderPriority;

    @Column(name = DBConstants.COLUMN_IS_ACTIVE, nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Product> products;

    @Override
    protected String getId() {
        return this.productCategoryId;
    }

    @Override
    protected void setId(String id) {
        this.productCategoryId = id;
    }
}
