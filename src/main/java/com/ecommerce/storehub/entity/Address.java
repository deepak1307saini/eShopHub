package com.ecommerce.storehub.entity;


import com.ecommerce.storehub.util.DBConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = DBConstants.TABLE_ADDRESSES)
public class Address extends BaseEntity implements Serializable {
    @Id
    @Column(name = DBConstants.COLUMN_ADDRESS_ID, nullable = false)
    private String addressId;

    @Column(name = DBConstants.COLUMN_USER_ID, nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DBConstants.COLUMN_USER_ID, insertable = false, updatable = false)
    @ToString.Exclude
    private User user;

    @Column(name = DBConstants.COLUMN_GOOGLE_ADDRESS)
    private String googleAddress;

    @Column(name = DBConstants.COLUMN_LATITUDE, nullable = false)
    private float latitude;

    @Column(name = DBConstants.COLUMN_LONGITUDE, nullable = false)
    private float longitude;
    @Column(name = DBConstants.COLUMN_ADDRESS_TYPE, nullable = false)
    private String addressType;
    @Column(name = DBConstants.COLUMN_CITY)
    private String city;

    @Column(name = DBConstants.COLUMN_STATE)
    private String state;
    @Column(name = DBConstants.COLUMN_COUNTRY)
    private String country;
    @Column(name = DBConstants.COLUMN_POSTAL_CODE)
    private String postalCode;
    @Column(name =DBConstants.COLUMN_IS_DEFAULT)
    private boolean isDefault;
    @Column(name = DBConstants.COLUMN_LANDMARK)
    private String landmark;

    @Override
    protected String getId() {
        return this.addressId;
    }

    @Override
    protected void setId(String id) {
        this.addressId = id;
    }
}
