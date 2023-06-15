package com.whatsapp.api.domain.webhook.engaglab.type;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used when an event happened in a specific EngageLab.
 */
public enum NotificationEventType {

    /**
     * 嵌入式注册成功.
     */
    @JsonProperty("whatsapp_bsp_add_waba")
    ADD_WABA,

    /**
     * 预估费用
     */
    @JsonProperty("whatsapp_bsp_delivery_estimate_cost")
    ESTIMATE_COST,

    /**
     * 预估费用
     */
    @JsonProperty("delivery_estimate_cost")
    DELIVERY_ESTIMATE_COST
}
