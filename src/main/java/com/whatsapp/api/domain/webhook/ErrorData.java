package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Error data.
 */
@Data
public class ErrorData{
        @JsonProperty("details")
        String details;
}