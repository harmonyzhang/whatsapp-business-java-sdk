package com.whatsapp.api.impl;

import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MediaHandlesResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhook;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhookResponse;
import com.whatsapp.api.service.WhatsappEngagelabApiService;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.List;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createServiceBasic;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;
import static com.whatsapp.api.configuration.WhatsappApiConfig.ENGAGELAB_DOMAIN;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://jiguang-docs.yuque.com/te6n14/whatsapp.engagelab/birhgucglgdgqc6c">Engagelab WhatsApp API</a>
 */
public class WhatsappEngagelabApi {

    private final WhatsappEngagelabApiService whatsappEngagelabApiService;


    /**
     * Instantiates a new Whatsapp business cloud api.
     *
     * @param token the token
     */
    public WhatsappEngagelabApi(String token) {
        this.whatsappEngagelabApiService = createServiceBasic(WhatsappEngagelabApiService.class, token, ENGAGELAB_DOMAIN);

    }

    /**
     * Use this endpoint to send text, media, contacts, location, and interactive messages,
     * as well as message templates to your customers.
     *
     * @param message       The {@link Message} object.
     * @return {@link MessageResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">official documentation</a>
     */
    public MessageResponse sendMessage(Message message) {
        return executeSync(whatsappEngagelabApiService.sendMessage(message));
    }

    /**
     * Use the WhatsApp Business Management API to create new message templates,
     * media message templates, or interactive message templates.
     *
     * @param messageTemplate           {@link MessageTemplate} object
     * @return {@link Template} template
     */
    public MessageTemplateIDResponse createMessageTemplate(MessageTemplate messageTemplate) {

        return executeSync(whatsappEngagelabApiService.createMessageTemplate(messageTemplate));
    }

    /**
     * Retrieve templates call.
     *
     * @return the call
     */
    public List<Template> retrieveTemplates(){
        return executeSync(whatsappEngagelabApiService.retrieveTemplates());
    }

    /**
     * Update message template message template id response.
     *
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the message template id response
     */
    public Response updateMessageTemplate(String messageTemplateId, MessageTemplate messageTemplate) {

        return executeSync(whatsappEngagelabApiService.updateMessageTemplate(messageTemplateId, messageTemplate));
    }

    /**
     * Delete message template message template success response.
     *
     * @param name                      the name
     * @return the message template success response
     */
    public Response deleteMessageTemplate(String name) {

        return executeSync(whatsappEngagelabApiService.deleteMessageTemplate(name));
    }

    /**
     * 设置回调地址
     *
     * @param setWebhook                      the setWebhook
     * @return the setWebhook success response
     */
    public SetWebhookResponse webhooks(SetWebhook setWebhook) {

        return executeSync(whatsappEngagelabApiService.webhooks(setWebhook));
    }

    /**
     * <p>处理模版示例媒体文件</p>
     *
     * @param file
     * @return {@link MediaHandlesResponse}
     */
    public MediaHandlesResponse mediaHandles(File file) {

        RequestBody requestFile = MultipartBody.create(file, null);

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        return executeSync(whatsappEngagelabApiService.mediaHandles(body));
    }



}
