package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Origin.
 */
@Data
public class Origin{
    @JsonProperty("type") String type;
}