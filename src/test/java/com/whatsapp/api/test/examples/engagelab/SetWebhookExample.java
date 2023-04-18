package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.domain.webhook.engaglab.SelectEvents;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhook;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhookResponse;
import com.whatsapp.api.domain.webhook.engaglab.type.EventType;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.impl.WhatsappEngagelabBspApi;
import com.whatsapp.api.test.TestConstants;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SetWebhookExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        SetWebhook setWebhook = new SetWebhook();
        setWebhook.setDescription("");
        setWebhook.setNotifyUrl("");

        SelectEvents selectEvents = new SelectEvents();
        // 消息状态事件
        selectEvents.setStatus(Arrays.stream(MessageStatus.values()).map(s -> s.getValue()).collect(Collectors.toList()));
        // 消息响应事件
        selectEvents.setResponse(Arrays.stream(EventType.values()).map(e -> e.name().toLowerCase()).collect(Collectors.toList()));

        setWebhook.setSelectEvents(selectEvents);

        SetWebhookResponse response =   whatsappEngagelabApi.webhooks(setWebhook);
        System.out.println(response);

    }
}
