package com.ecommerce.storehub.util;

import java.security.SecureRandom;

public class OTPGenerator {
    public static String generateOTP() {
        SecureRandom secureRandom = new SecureRandom();
        int otp = 100000 + secureRandom.nextInt(900000); // Generates a number between 100000 and 999999
        return String.valueOf(otp);
    }

}
