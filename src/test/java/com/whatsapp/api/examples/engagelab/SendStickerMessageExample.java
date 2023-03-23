package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.StickerMessage;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.Arrays;


public class SendStickerMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        StickerMessage stickerMessage = new StickerMessage()//
                //.setId("527984052814860");// media id (uploaded before)
                .setLink("http://sample-file.bazadanni.com/download/images/webp/sample.webp");

        Message message = Message.MessageBuilder.builder()//
            .setFrom(TestConstants.PHONE_NUMBER_ID)
            .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
            .buildMessage(Body.BodyBuilder.builder().buildStickerBody(stickerMessage));

        MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        System.out.println(messageResponse);

    }
}
