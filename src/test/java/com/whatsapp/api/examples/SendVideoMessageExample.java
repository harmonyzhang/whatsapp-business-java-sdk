package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.VideoMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;


public class SendVideoMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

        VideoMessage videoMessage = new VideoMessage()//
                .setId("1236364143659727")// media id (uploaded before)
                .setCaption("See this video");


        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildVideoMessage(videoMessage);


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
