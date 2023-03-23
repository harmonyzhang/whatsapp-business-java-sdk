package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.RestrictionType;
import lombok.Data;

/**
 * The type Restriction info.
 */
@Data
public class RestrictionInfo{
        @JsonProperty("restriction_type") RestrictionType restrictionType;

        @JsonProperty("expiration") String expiration;
}
