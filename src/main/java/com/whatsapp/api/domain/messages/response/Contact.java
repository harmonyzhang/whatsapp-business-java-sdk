package com.whatsapp.api.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Contact.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact{
        @JsonProperty("input") String input;

        @JsonProperty("wa_id") String waId;
}
