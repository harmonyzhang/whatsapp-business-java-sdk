package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Conversation.
 */
@Data
public class Conversation {

        @JsonProperty("expiration_timestamp") String expirationTimestamp;

        @JsonProperty("origin") Origin origin;

        @JsonProperty("id") String id;

}