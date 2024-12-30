package com.ecommerce.storehub.entity;

import com.ecommerce.storehub.util.DBConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = DBConstants.TABLE_SHOPS)
public class Shop extends BaseEntity implements Serializable {
    @Id
    @Column(name = DBConstants.COLUMN_SHOP_ID, nullable = false)
    private String shopId;

    @Column(name = DBConstants.COLUMN_OWNER_ID, nullable = false)
    private String ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_OWNER_ID, insertable = false, updatable = false)
    private User owner;

    @Column(name = DBConstants.COLUMN_SHOP_NAME, nullable = false)
    private String shopName;

    @Column(name = DBConstants.COLUMN_SHOP_DESCRIPTION)
    private String shopDescription;

    @Column(name = DBConstants.COLUMN_SHOP_ADDRESS_ID, nullable = false)
    private String shopAddressId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_SHOP_ADDRESS_ID, insertable = false, updatable = false)
    private Address shopAddress;

    @Column(name = DBConstants.COLUMN_SHOP_PHONE)
    private String shopPhone;

    @Column(name = DBConstants.COLUMN_SHOP_EMAIL, unique = true)
    private String shopEmail;

    @Column(name = DBConstants.COLUMN_SHOP_LOGO)
    private String shopLogo;

    @Column(name = DBConstants.COLUMN_SHOP_CATEGORY)
    private String shopCategory;

    @Column(name = DBConstants.COLUMN_PAYMENT_METHODS)
    private String paymentMethods;

//    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
//    private List<Product> products;

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    private List<ProductCategory> productCategories;

    @Override
    protected String getId() {
        return this.shopId;
    }

    @Override
    protected void setId(String id) {
        this.shopId = id;
    }
}
