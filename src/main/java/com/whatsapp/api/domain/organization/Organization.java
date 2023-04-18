package com.whatsapp.api.domain.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Organization {

    /**
     * 组织时区
     */
    @JsonProperty("timezone") String timezone;

    /**
     * 组织名称
     */
    @JsonProperty("name") String name;


}
