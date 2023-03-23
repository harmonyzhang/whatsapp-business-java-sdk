package com.whatsapp.api.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Cursors.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cursors {
    @JsonProperty("before") String before;

    @JsonProperty("after") String after;
}