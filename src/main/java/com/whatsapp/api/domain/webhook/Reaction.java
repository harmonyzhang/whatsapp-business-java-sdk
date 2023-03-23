package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Reaction.
 */
@Data
public class Reaction {

    @JsonProperty("emoji") String emoji;

    @JsonProperty("message_id") String messageId;
}