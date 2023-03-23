package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Address.
 */
@Data
public class Address{

        @JsonProperty("zip") String zip;

        @JsonProperty("country") String country;

        @JsonProperty("country_code") String countryCode;

        @JsonProperty("city") String city;

        @JsonProperty("street") String street;

        @JsonProperty("state") String state;

        @JsonProperty("type") String type;

}