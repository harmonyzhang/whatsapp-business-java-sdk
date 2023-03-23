package com.whatsapp.api.domain.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * The type Whatsapp api error.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WhatsappApiError{
        @JsonProperty("error")
        Error error;

        @JsonProperty("code")
        String code;

        @JsonProperty("message")
        String message;

        public WhatsappApiError(Error error) {
                this.error = error;
        }
}
