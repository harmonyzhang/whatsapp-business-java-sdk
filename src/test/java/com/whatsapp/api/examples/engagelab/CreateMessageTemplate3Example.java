package com.whatsapp.api.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.*;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.utils.Formatter;

import static com.whatsapp.api.TestConstants.*;
import static com.whatsapp.api.TestConstants.ENGAGELAB_DEV_SECRET;

public class CreateMessageTemplate3Example {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(ENGAGELAB_DEV_KEY, ENGAGELAB_DEV_SECRET);

        MessageTemplate template = new MessageTemplate();

        template.setName("schedule_confirmation3")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Confirmação de Atendimento")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria", "04/11/2022", "13:30")//
                        ))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//
                        .addButton(new QuickReplyButton("REMARCAR")//
                        )


                )//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


        ;

        MessageTemplateIDResponse response = whatsappEngagelabApi.createMessageTemplate(template);

        System.out.println(response);
    }
}
