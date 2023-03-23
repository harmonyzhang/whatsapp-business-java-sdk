package com.whatsapp.api.service;


import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.domain.templates.response.Template;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;
import static com.whatsapp.api.configuration.WhatsappApiConfig.ENGAGELAB_API_VERSION;


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
    @POST("/" + ENGAGELAB_API_VERSION + "/messages")
    Call<MessageResponse> sendMessage(@Body Message message);

    /**
     * Create message template call.
     *
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/" + ENGAGELAB_API_VERSION + "/templates")
    Call<MessageTemplateIDResponse> createMessageTemplate(@Body MessageTemplate messageTemplate);


    /**
     * Retrieve templates call.
     *
     * @return the call
     */
    @GET("/" + ENGAGELAB_API_VERSION + "/templates")
    Call<List<Template>> retrieveTemplates();

    /**
     * Update message template call.
     *
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the call
     */
    @PUT("/" + ENGAGELAB_API_VERSION + "/templates/{message-template-id}")
    Call<Response> updateMessageTemplate(@Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    /**
     * Delete message template call.
     *
     * @param name                      the name
     * @return the call
     */
    @DELETE("/" + ENGAGELAB_API_VERSION + "/templates/{message-template-name}")
    Call<Response> deleteMessageTemplate(@Path("message-template-name") String name);




}
