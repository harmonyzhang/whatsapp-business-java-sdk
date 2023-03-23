package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import static com.whatsapp.api.TestConstants.ENGAGELAB_DEV_KEY;
import static com.whatsapp.api.TestConstants.ENGAGELAB_DEV_SECRET;

public class DeleteMessageTemplate {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(ENGAGELAB_DEV_KEY, ENGAGELAB_DEV_SECRET);

        Response response = whatsappEngagelabApi.deleteMessageTemplate("hello");
        System.out.println(response);
    }
}
