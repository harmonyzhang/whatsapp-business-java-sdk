package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Pricing.
 */
@Data
public class Pricing {

    @JsonProperty("pricing_model") String pricingModel;

    @JsonProperty("category") String category;

    @JsonProperty("billable") boolean billable;

}