package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Interactive.
 */
@Data
public class Interactive {
        @JsonProperty("list_reply") ListReply listReply;

        @JsonProperty("type") String type;

        @JsonProperty("button_reply") ButtonReply buttonReply;
}