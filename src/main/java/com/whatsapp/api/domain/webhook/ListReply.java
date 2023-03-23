package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type List reply.
 */
@Data
public class ListReply{

        @JsonProperty("description")
        String description;

        @JsonProperty("id")
        String id;

        @JsonProperty("title")
        String title;
}