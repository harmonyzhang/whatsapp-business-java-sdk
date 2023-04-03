package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NotificationPhone {

    /**
     * 发送号号码
     */
    @JsonProperty("display_phone_number") String phoneNumber;

    /**
     * 极光未给描述，暂时不用
     */
    @JsonProperty("numberId") String numberId;


}
