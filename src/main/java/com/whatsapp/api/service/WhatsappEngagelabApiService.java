package com.whatsapp.api.service;


import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MediaHandlesResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhook;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhookResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


/**
 * Engagelab（极光）Whatsapp api 接口
 */
public interface WhatsappEngagelabApiService {


    /**
     * Send message call.
     *
     * @param message       the message
     * @return the call
     */
    @POST("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/messages")
    Call<MessageResponse> sendMessage(@Body Message message);

    /**
     * Create message template call.
     *
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/templates")
    Call<MessageTemplateIDResponse> createMessageTemplate(@Body MessageTemplate messageTemplate);


    /**
     * Retrieve templates call.
     *
     * @return the call
     */
    @GET("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/templates")
    Call<List<Template>> retrieveTemplates();

    /**
     * Update message template call.
     *
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the call
     */
    @PUT("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/templates/{message-template-id}")
    Call<Response> updateMessageTemplate(@Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    /**
     * Delete message template call.
     *
     * @param name                      the name
     * @return the call
     */
    @DELETE("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/templates/{message-template-name}")
    Call<Response> deleteMessageTemplate(@Path("message-template-name") String name);

    /**
     * 设置回调地址
     * @param setWebhook                      the setWebhook
     * @return the call
     */
    @POST("/" + WhatsappApiConfig.ENGAGELAB_DEV_API_VERSION + "/webhooks")
    Call<SetWebhookResponse> webhooks(@Body SetWebhook setWebhook);


    /**
     * <p>处理模版示例媒体文件</p>
     *
     * @param body
     * @return {@link Call<MediaHandlesResponse>}
     */
    @Multipart
    @POST("/" + WhatsappApiConfig.ENGAGELAB_DEV_API_VERSION + "/media/handles")
    Call<MediaHandlesResponse> mediaHandles(@Part MultipartBody.Part body);
}
