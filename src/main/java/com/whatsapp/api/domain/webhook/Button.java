package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Button.
 */
@Data
public class Button{
        @JsonProperty("payload") String payload;

        @JsonProperty("text") String text;
}