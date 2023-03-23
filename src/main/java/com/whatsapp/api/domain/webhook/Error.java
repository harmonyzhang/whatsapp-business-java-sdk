package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Error.
 */
@Data
public class Error {
        @JsonProperty("code")
        int code;

        @JsonProperty("title")
        String title;

        @JsonProperty("message")
        String message;

        @JsonProperty("error_data")
        ErrorData errorData;
}