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
@Table(name = DBConstants.TABLE_USERS)
public class User extends BaseEntity implements Serializable {
    @Id
    @Column(name = DBConstants.COLUMN_USER_ID, nullable = false)
    private String userId;

    @Column(name = DBConstants.COLUMN_EMAIL, nullable = false)
    private String email;

    @Column(name = DBConstants.COLUMN_PASSWORD, nullable = false)
    private String password;

    @Column(name = DBConstants.COLUMN_FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = DBConstants.COLUMN_MIDDLE_NAME, nullable = true)
    private String middleName;

    @Column(name = DBConstants.COLUMN_LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = DBConstants.COLUMN_USER_NAME, nullable = false)
    private String username;

    @Column(name = DBConstants.COLUMN_PHONE_NUMBER, nullable = false)
    private String phoneNumber;

    @Column(name = DBConstants.COLUMN_ROLE_NAME, nullable = false)
    private String roleName;

    @Column(name = DBConstants.COLUMN_STATUS, nullable = false)
    private String status;

    @Column(name = DBConstants.COLUMN_LAST_LOGIN)
    private Long lastLogin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @Override
    protected String getId() {
        return this.userId;
    }

    @Override
    protected void setId(String id) {
        this.userId = id;
    }
}
