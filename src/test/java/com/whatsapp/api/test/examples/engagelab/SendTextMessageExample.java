package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.utils.Formatter;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SendTextMessageExample {

    public static void main(String[] args) throws UnsupportedEncodingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Map<String, Object> customArgs = new HashMap<>();
        customArgs.put("a", "test1");

        Message message = MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1)) //
                .setRequestId("1122") // 自定义的请求 ID，用来标识是哪条请求，响应时返回。
                .setCustomArgs(customArgs) // 自定义的信息，在消息状态回调中返回给开发者。
                .buildMessage(Body.BodyBuilder.builder().buildTextBody(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false)));


        MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        System.out.println(messageResponse);

    }
}
