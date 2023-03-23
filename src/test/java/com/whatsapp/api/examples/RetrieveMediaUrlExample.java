package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.TOKEN;

public class RetrieveMediaUrlExample {

    public static void main(String[] args)  {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TOKEN);

        Media response = whatsappBusinessCloudApi.retrieveMediaUrl("1227829768162607");

        System.out.println(response);
    }


}
