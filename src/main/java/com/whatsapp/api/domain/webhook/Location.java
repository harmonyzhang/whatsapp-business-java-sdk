package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Location.
 */
@Data
public class Location{
    @JsonProperty("address") String address;

    @JsonProperty("latitude") double latitude;

    @JsonProperty("name") String name;

    @JsonProperty("longitude") double longitude;
}