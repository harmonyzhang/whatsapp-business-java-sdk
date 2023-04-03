package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.engaglab.type.EventType;
import lombok.Data;

import java.util.List;

@Data
public class NotificationWaba {

    /**
     * WhatsApp 商业账户编号
     */
    @JsonProperty("waba_id") String wabaId;

    /**
     * WhatsApp 商业账户名称
     */
    @JsonProperty("waba_name") String wabaName;

    /**
     * WhatsApp 商业账户下的发送号列表
     */
    @JsonProperty("phone_list") List<NotificationPhone> phoneList;

    /**
     * 响应代码
     */
    @JsonProperty("code") int code;

    /**
     * 响应消息
     */
    @JsonProperty("message") String message;

}
