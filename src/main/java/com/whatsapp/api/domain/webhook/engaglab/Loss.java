package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Loss.
 */
public class Loss {

    /**
        折损阶段
        1：计划目标 ~ 有效目标，即无效目标
        2：有效目标 ~ 发送，即发送失败
        3：发送 ~ 送达。即送达失败
     */
    @JsonProperty("loss_step") int step;

    /**
    折损来源，取值：
    engagelab：EngageLab WhatsApp 服务进行校验产生的折损
    meta：Meta 官方返回的错误
     */
    @JsonProperty("loss_source") String source;


}