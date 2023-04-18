package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SetWebhook {

    /**
     * 描述信息
     */
    @JsonProperty("description") String description;

    /**
     * 回调地址
     */
    @JsonProperty("notify_url") String notifyUrl;

    /**
     * 事件
     */
    @JsonProperty("select_events") SelectEvents selectEvents;




}
