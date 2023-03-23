package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import lombok.Data;

import java.util.List;

/**
 * The type Status.
 */
@Data
public class Status{
    @JsonProperty("id") String id;

    @JsonProperty("conversation") Conversation conversation;

    @JsonProperty("pricing") Pricing pricing;

    @JsonProperty("recipient_id") String recipientId;

    @JsonProperty("status") MessageStatus status;

    @JsonProperty("timestamp") String timestamp;

    @JsonProperty("errors") List<Error> errors;
}