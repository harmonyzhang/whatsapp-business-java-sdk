package com.whatsapp.api.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Paging.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paging {

    @JsonProperty("cursors") Cursors cursors;

    @JsonProperty("next") String next;

}