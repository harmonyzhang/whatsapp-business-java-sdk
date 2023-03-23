package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Button reply.
 *
 * @param id    The unique identifier of the button.
 * @param title The title of the button.
 */
@Data
public class ButtonReply {
        @JsonProperty("id")
        String id;

        @JsonProperty("title")
        String title;
}