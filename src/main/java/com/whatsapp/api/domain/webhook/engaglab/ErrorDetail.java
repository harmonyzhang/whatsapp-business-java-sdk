package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Error data.
 */
@Data
public class ErrorDetail {
        @JsonProperty("message")
        String message;
}