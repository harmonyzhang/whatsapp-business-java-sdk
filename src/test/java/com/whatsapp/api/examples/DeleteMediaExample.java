package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

public class DeleteMediaExample {

    public static void main(String[] args)  {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

        //delete media
        Response response = whatsappBusinessCloudApi.deleteMedia("723050006231302");

        System.out.println(response);

    }


}
