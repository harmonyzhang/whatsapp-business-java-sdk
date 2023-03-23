package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

public class DeleteMessageTemplate {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Response response = whatsappEngagelabApi.deleteMessageTemplate("hello");
        System.out.println(response);
    }
}
