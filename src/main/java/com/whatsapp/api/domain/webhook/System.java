package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type System.
 */
@Data
public class System{
    @JsonProperty("new_wa_id") String newWaId;

    @JsonProperty("body") String body;

    @JsonProperty("type") String type;
}