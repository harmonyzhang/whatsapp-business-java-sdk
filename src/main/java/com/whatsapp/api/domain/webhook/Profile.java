package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Optional.
 *
 * @param name Specifies the sender's profile name.
 */
@Data
public class Profile{

    @JsonProperty("name") String name;
}