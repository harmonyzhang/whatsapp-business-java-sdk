package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Text.
 *
 * @param body The text of the text message.
 */
@Data
public class Text {
    @JsonProperty("body") String body;
}