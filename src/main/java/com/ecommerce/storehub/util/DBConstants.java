package com.ecommerce.storehub.util;

public class DBConstants {
    public static final String COLUMN_CREATED_AT = "CREATED_AT";
    public static final String COLUMN_MODIFIED_AT = "MODIFIED_AT";
    public static final String COLUMN_CREATED_BY = "CREATED_BY";
    public static final String COLUMN_MODIFIED_BY = "MODIFIED_BY";
    public static final String COLUMN_DELETED = "DELETED";

    //User
    public static final String TABLE_USERS = "USERS";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_LAST_LOGIN = "LAST_LOGIN";
    public static final String COLUMN_STATUS = "STATUS";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String COLUMN_MIDDLE_NAME = "MIDDLE_NAME";
    public static final String COLUMN_ROLE_NAME = "ROLE_NAME";

    //Address
    public static final String TABLE_ADDRESSES = "ADDRESSES";
    public static final String COLUMN_ADDRESS_ID = "ADDRESS_ID";
    public static final String COLUMN_GOOGLE_ADDRESS = "GOOGLE_ADDRESS";
    public static final String COLUMN_LATITUDE = "LATITUDE";
    public static final String COLUMN_LONGITUDE = "LONGITUDE";
    public static final String COLUMN_ADDRESS_TYPE = "ADDRESS_TYPE";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_STATE = "STATE";
    public static final String COLUMN_COUNTRY = "COUNTRY";
    public static final String COLUMN_IS_DEFAULT = "IS_DEFAULT";
    public static final String COLUMN_POSTAL_CODE = "POSTAL_CODE";
    public static final String COLUMN_LANDMARK = "LANDMARK";

    // Shop Table
    public static final String TABLE_SHOPS = "SHOPS";
    public static final String COLUMN_SHOP_ID = "SHOP_ID";
    public static final String COLUMN_OWNER_ID = "OWNER_ID";
    public static final String COLUMN_SHOP_NAME = "SHOP_NAME";
    public static final String COLUMN_SHOP_DESCRIPTION = "SHOP_DESCRIPTION";
    public static final String COLUMN_SHOP_ADDRESS_ID = "SHOP_ADDRESS_ID";
    public static final String COLUMN_SHOP_PHONE = "SHOP_PHONE";
    public static final String COLUMN_SHOP_EMAIL = "SHOP_EMAIL";
    public static final String COLUMN_SHOP_LOGO = "SHOP_LOGO";
    public static final String COLUMN_SHOP_CATEGORY = "SHOP_CATEGORY";
    public static final String COLUMN_PAYMENT_METHODS = "PAYMENT_METHODS";

    // Product Category Table
    public static final String TABLE_PRODUCT_CATEGORIES = "PRODUCT_CATEGORIES";
    public static final String COLUMN_CATEGORY_ID = "CATEGORY_ID";
    public static final String COLUMN_CATEGORY_NAME = "CATEGORY_NAME";
    public static final String COLUMN_CATEGORY_DESCRIPTION = "CATEGORY_DESCRIPTION";
    public static final String COLUMN_ORDER_PRIORITY = "ORDER_PRIORITY";
    public static final String COLUMN_IS_ACTIVE = "IS_ACTIVE";

    // Product Table
    public static final String TABLE_PRODUCTS = "PRODUCTS";
    public static final String COLUMN_PRODUCT_ID = "PRODUCT_ID";
    public static final String COLUMN_PRODUCT_CATEGORY_ID = "PRODUCT_CATEGORY_ID";
    public static final String COLUMN_PRODUCT_NAME = "PRODUCT_NAME";
    public static final String COLUMN_PRICE = "PRICE";
    public static final String COLUMN_STOCK_QUANTITY = "STOCK_QUANTITY";
}
