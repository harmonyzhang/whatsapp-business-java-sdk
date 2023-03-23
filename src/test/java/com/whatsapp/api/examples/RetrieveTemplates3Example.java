package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class RetrieveTemplates3Example {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);

        MessageTemplates templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, "welcome_template3");

        ObjectMapper mapper = new ObjectMapper();


        System.out.println(mapper.writeValueAsString(templates));
    }
}
