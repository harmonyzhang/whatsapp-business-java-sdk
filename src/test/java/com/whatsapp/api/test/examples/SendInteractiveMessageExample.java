package com.whatsapp.api.test.examples;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.messages.type.ButtonType;
import com.whatsapp.api.domain.messages.type.HeaderType;
import com.whatsapp.api.domain.messages.type.InteractiveMessageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;


public class SendInteractiveMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

        productMessage(whatsappBusinessCloudApi);

        multiProductMessage(whatsappBusinessCloudApi);

        buttonMessage(whatsappBusinessCloudApi);

        listMessage(whatsappBusinessCloudApi);

    }

    private static void multiProductMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("1") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU1-in-catalog")) //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU2-in-catalog")) //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU3-in-catalog")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Title 2") //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU5-in-catalog"))) //
                        ) //
                        .setType(InteractiveMessageType.PRODUCT_LIST) //
                        .setHeader(new Header() //
                                .setType(HeaderType.TEXT) //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void productMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("1") //
                                .setProductRetailerId("ID_TEST_ITEM_1")) //
                        .setType(InteractiveMessageType.PRODUCT) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void buttonMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY)
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_1") //
                                                .setTitle("BUTTON_TITLE_1"))) //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY)
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_2") //
                                                .setTitle("BUTTON_TITLE_2")))
                        ) //
                        .setType(InteractiveMessageType.BUTTON) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void listMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        Message message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setButtonText("BUTTON_TEXT") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_1_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_1_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_1_ROW_3_DESCRIPTION")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Title 2") //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_2_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_2_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_2_ROW_3_DESCRIPTION")) //
                                )
                        ) //
                        .setType(InteractiveMessageType.LIST) //
                        .setHeader(new Header() //
                                .setType(HeaderType.TEXT) //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                        .setFooter(new Footer() //
                                .setText("Footer Text")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }
}
