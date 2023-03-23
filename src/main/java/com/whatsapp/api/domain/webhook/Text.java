package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Text.
 */
@Data
public class Text {
    @JsonProperty("body") String body;
}