package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.AudioMessage;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.Arrays;


public class SendAudioMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        AudioMessage audioMessage = new AudioMessage()//
                //.setId("6418001414900549");
                .setLink("https://file-examples.com/storage/fe5947fd2362fc197a3c2df/2017/11/file_example_MP3_700KB.mp3");

       Message message = Message.MessageBuilder.builder()//
               .setFrom(TestConstants.PHONE_NUMBER_ID)
               .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
               .buildMessage(Body.BodyBuilder.builder().buildAudioBody(audioMessage));

        MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        System.out.println(messageResponse);

    }
}
