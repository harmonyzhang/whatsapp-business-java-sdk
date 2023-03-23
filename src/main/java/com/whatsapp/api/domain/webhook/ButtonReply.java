package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Button reply.
 */
@Data
public class ButtonReply {
        @JsonProperty("id")
        String id;

        @JsonProperty("title")
        String title;
}