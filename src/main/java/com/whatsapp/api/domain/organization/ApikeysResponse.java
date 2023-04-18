package com.whatsapp.api.domain.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApikeysResponse {

    /**
     * API 秘钥key
     */
    @JsonProperty("whatsapp_dev_key") String devKey;

    /**
     * API 秘钥的密码
     */
    @JsonProperty("whatsapp_dev_secret")
    String devSecret;

}
