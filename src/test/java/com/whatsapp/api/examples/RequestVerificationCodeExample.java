package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.phone.type.CodeMethodType;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class RequestVerificationCodeExample {

    public static void main(String[] args)  {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi(TestConstants.TOKEN);
        //request the code
        Response response = whatsappBusinessManagementApi.requestCode(TestConstants.PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US));

        System.out.println(response);

        //verify the code
        Response response2 = whatsappBusinessManagementApi.verifyCode(TestConstants.PHONE_NUMBER_ID, new VerifyCode("0000"));

        System.out.println(response2);

    }
}