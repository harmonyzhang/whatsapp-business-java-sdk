package com.whatsapp.api.test.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

public class RetrieveTemplates2Example {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TestConstants.TOKEN);

        MessageTemplates templates = whatsappBusinessCloudApi.retrieveTemplates(TestConstants.WABA_ID, 2);

        ObjectMapper mapper = new ObjectMapper();


        System.out.println(mapper.writeValueAsString(templates));
    }
}
