package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.type.AddressType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.*;

public class SendContactMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);
        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildContactMessage(new ContactMessage()//
                        .addContacts(new Contact()//
                                .addPhones(new Phone()//
                                        .setPhone(TestConstants.PHONE_NUMBER_1)//
                                        .setType(AddressType.HOME))//
                                .setName(new Name()//
                                        .setFormattedName("Mauricio Binda")//
                                        .setFirstName("Mauricio"))//
                        ));


        whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

    }
}
