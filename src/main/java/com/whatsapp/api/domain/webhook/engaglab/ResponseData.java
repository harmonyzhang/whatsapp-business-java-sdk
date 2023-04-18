package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.Contact;
import com.whatsapp.api.domain.webhook.Conversation;
import com.whatsapp.api.domain.webhook.Message;
import com.whatsapp.api.domain.webhook.Pricing;
import lombok.Data;

/**
 * The type StatusData.
 */
@Data
public class ResponseData {

    /**
     * WhatsApp 官方返回的消息 ID
     */
    @JsonProperty("channel_message_id") String channelMessageId;

    /**
     * 发送号所属的 WhatsApp 商业账户的编号
     */
    @JsonProperty("whatsapp_business_account_id") String wabaId;

    /**
     * 发送方信息
     */
    @JsonProperty("contact") Contact contact;

    /**
     * 消息内容
     */
    @JsonProperty("message") Message message;

}