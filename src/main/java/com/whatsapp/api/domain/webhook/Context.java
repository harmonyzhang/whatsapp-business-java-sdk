package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Context.
 */
@Data
public class Context{

        @JsonProperty("from") String from;

        @JsonProperty("referred_product") ReferredProduct referredProduct;

        @JsonProperty("id") String id;

        @JsonProperty("forwarded") boolean forwarded;

        @JsonProperty("frequently_forwarded") boolean frequentlyForwarded;

}