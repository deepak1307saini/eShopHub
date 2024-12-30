package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.service.TwilioService;
import com.ecommerce.storehub.util.OTPGenerator;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class TwilioServiceImpl implements TwilioService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String twilioNumber;

    @Override
    public void sendOtp(String phoneNumber) {
        Twilio.init(accountSid, authToken);
        Message message = Message
                .creator(new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber(twilioNumber),
                        "StoreHub OTP: "+ OTPGenerator.generateOTP())
                .create();

        log.info(message.getBody());
    }
}
