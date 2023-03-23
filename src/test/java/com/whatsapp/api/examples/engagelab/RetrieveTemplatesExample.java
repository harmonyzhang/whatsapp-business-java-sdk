package com.whatsapp.api.examples.engagelab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.List;

import static com.whatsapp.api.TestConstants.*;
import static com.whatsapp.api.TestConstants.ENGAGELAB_DEV_SECRET;

public class RetrieveTemplatesExample {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(ENGAGELAB_DEV_KEY, ENGAGELAB_DEV_SECRET);

        List<Template> templates = whatsappEngagelabApi.retrieveTemplates();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(templates));
    }
}
