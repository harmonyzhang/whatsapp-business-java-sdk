package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

public class DeleteMessageTemplate {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TestConstants.TOKEN);


        whatsappBusinessCloudApi.deleteMessageTemplate(TestConstants.WABA_ID, "welcome_template");
    }
}
