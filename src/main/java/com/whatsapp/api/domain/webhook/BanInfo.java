package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Ban info.
 */
@Data
public class BanInfo {
    @JsonProperty("waba_ban_state") String wabaBanState;

    @JsonProperty("waba_ban_date") String wabaBanDate;
}
