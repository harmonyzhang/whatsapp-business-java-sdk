package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Disable info.
 */
@Data
public class DisableInfo {

    @JsonProperty("disable_date") String disableDate;
}
