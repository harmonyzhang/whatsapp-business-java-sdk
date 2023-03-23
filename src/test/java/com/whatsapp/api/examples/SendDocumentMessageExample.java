package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.DocumentMessage;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendDocumentMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

        DocumentMessage documentMessage = new DocumentMessage()//
                .setId("1238834210396519")// media id (uploaded before)
                .setCaption("Media Object details from developers.facebook.com")//
                .setFileName("Media oject.pdf");

        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildDocumentMessage(documentMessage);


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
