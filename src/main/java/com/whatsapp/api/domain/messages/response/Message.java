package com.whatsapp.api.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Message.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

        @JsonProperty("id") String id;
}
