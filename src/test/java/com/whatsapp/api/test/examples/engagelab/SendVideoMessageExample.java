package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.VideoMessage;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

import java.util.Arrays;


public class SendVideoMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        VideoMessage videoMessage = new VideoMessage()//
                //.setId("1236364143659727")// media id (uploaded before)
                .setLink("https://img.jiguang.cn/jiguang/public/videos/432acc5.mp4")
                .setCaption("See this video");

       com.whatsapp.api.domain.messages.engaglab.Message message = com.whatsapp.api.domain.messages.engaglab.Message.MessageBuilder.builder()//
               .setFrom(TestConstants.PHONE_NUMBER_ID)
               .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
               .buildMessage(Body.BodyBuilder.builder().buildVideoBody(videoMessage));

        MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        System.out.println(messageResponse);
    }
}
