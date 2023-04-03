package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Phone.
 */
@Data
public class Phone{

    @JsonProperty("phone") String phone;

    @JsonProperty("wa_id") String waId;

    @JsonProperty("type") String type;

}