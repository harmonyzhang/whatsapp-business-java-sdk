package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NotificationData {

    /**
     * 组织id
     */
    @JsonProperty("org_id") String orgId;

    /**
     * WhatsApp 商业账户列表
     * 一般情况下，只会返回「当时注册成功的这个 WhatsApp 账户」，但经过测试某些情况下 Meta 会返回多个 WhatsApp 账户（这些情况正在与 Meta 方确认），因此我们使用数组形式返回该信息
     */
    @JsonProperty("waba_list") List<NotificationWaba> wabaList;


}
