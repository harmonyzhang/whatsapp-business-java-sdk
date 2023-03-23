package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Optional.
 */
@Data
public class Profile{

    @JsonProperty("name") String name;
}