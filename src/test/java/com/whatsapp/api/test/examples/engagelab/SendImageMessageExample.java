package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.ImageMessage;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.Arrays;


public class SendImageMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        ImageMessage imageMessage = new ImageMessage()//
                .setLink("https://res.theengagelab.com/console/core/img/engagelab.7df2c538.svg")
                .setCaption("See this image, please");

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildImageBody(imageMessage));

        MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        System.out.println(messageResponse);

    }
}
