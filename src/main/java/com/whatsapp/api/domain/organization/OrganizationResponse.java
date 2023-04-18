package com.whatsapp.api.domain.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrganizationResponse {

    /**
     * 组织id
     */
    @JsonProperty("org_id") String orgId;

    @JsonProperty("code")
    String code;

    @JsonProperty("message")
    String message;


}
