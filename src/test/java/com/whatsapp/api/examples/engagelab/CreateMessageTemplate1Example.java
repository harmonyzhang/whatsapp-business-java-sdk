package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappEngagelabApi;

public class CreateMessageTemplate1Example {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY, TestConstants.ENGAGELAB_DEV_SECRET);

        MessageTemplate template = new MessageTemplate();

        template.setName("welcome_template3")
                .setCategory(Category.TRANSACTIONAL)
                .setLanguage(LanguageType.EN_US)
                .addComponent(new HeaderComponent()
                        .setText("Wellcome title")
                        .setFormat(HeaderFormat.TEXT))
                .addComponent(new BodyComponent()
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "s")
                        ))
        ;

        MessageTemplateIDResponse response =   whatsappEngagelabApi.createMessageTemplate(template);
        System.out.println(response);

    }
}
