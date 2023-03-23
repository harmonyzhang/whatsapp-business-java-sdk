package com.whatsapp.api.domain.messages.engaglab.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * The type Message response.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse{
        @JsonProperty("message_id") String messageId;

        @JsonProperty("request_id") String requestId;

}
