package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Button.
 *
 * @param payload The developer-defined payload for the button when a business account sends interactive messages.
 * @param text    The button text
 */
@Data
public class Button{
        @JsonProperty("payload") String payload;

        @JsonProperty("text") String text;
}