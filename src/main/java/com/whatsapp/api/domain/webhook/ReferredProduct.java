package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Referred product.
 */
@Data
public class ReferredProduct {
    @JsonProperty("catalog_id") String catalogId;

    @JsonProperty("product_retailer_id") String productRetailerId;
}