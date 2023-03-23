package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Email.
 */
@Data
public class Email{

        @JsonProperty("type")
        String type;

        @JsonProperty("email")
        String email;
}