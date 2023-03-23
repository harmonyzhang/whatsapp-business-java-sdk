package com.whatsapp.api.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Message response.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse{
        @JsonProperty("messaging_product") String messagingProduct;

        @JsonProperty("contacts") List<Contact> contacts;

        @JsonProperty("messages") List<Message> messages;
}
