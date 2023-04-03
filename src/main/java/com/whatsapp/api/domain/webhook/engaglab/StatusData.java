package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.Conversation;
import com.whatsapp.api.domain.webhook.Error;
import com.whatsapp.api.domain.webhook.Pricing;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import lombok.Data;

import java.util.List;

/**
 * The type StatusData.
 */
@Data
public class StatusData {
    /**
     消息下发时间，历史记录上的消息发送时间，即用户调用API发送消息-调用API成功的那个时间
     */
    @JsonProperty("msg_time") long msgTime;

    /**
     * 可选，Meta 返回的msgid
     */
    @JsonProperty("channel_message_id") String channelMessageId;

    /**
     * 发送号 from 对应的 Whatsapp 商业账户编码
     */
    @JsonProperty("whatsapp_business_account_id") String wabaId;

    /**
     * 组织时区
     */
    @JsonProperty("timezone") String timezone;

    /**
     * 计划目标总数，只有当 message_status=plan 时这个才会有值
     */
    @JsonProperty("plan_user_total") int planUserTotal;

    /**
     * 接收方手机号码归属的国家/地区代码
     */
    @JsonProperty("country_code") String countryCode;

    @JsonProperty("from_phone_id") String fromPhoneId;

    @JsonProperty("conversation")
    Conversation conversation;

    @JsonProperty("pricing")
    Pricing pricing;
}