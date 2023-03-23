package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Component;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.TemplateMessage;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.domain.templates.type.ComponentType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.Arrays;

public class SendTemplateTextMessageExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Message message = com.whatsapp.api.domain.messages.engaglab.Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildTemplateBody(new TemplateMessage()//
                        .setLanguage(LanguageType.EN).setName("marketinguse")//
                        .addComponent( //
                                new Component(ComponentType.HEADER)//
                                        .addParameter(new TextParameter("order no: 13232332")//
                                        ))));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);
        System.out.println(response);
    }
}
