package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.Conversation;
import com.whatsapp.api.domain.webhook.Error;
import com.whatsapp.api.domain.webhook.Pricing;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import lombok.Data;

import java.util.List;

/**
 * The type Status.
 */
@Data
public class Status {

    @JsonProperty("message_status") MessageStatus status;

    @JsonProperty("status_data") StatusData statusData;

    @JsonProperty("error_code") int errorCode;

    @JsonProperty("error_detail") ErrorDetail errorDetail;

    @JsonProperty("loss")  Loss loss;
}