package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Org.
 */
public class Org{

    @JsonProperty("company") String company;

    @JsonProperty("department") String department;

    @JsonProperty("title") String title;

}