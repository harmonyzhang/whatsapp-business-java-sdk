package com.whatsapp.api.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Message template success response.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty("success") boolean success;

    @JsonProperty("code")
    String code;

    @JsonProperty("message")
    String message;

    public void setMessage(String message) {
        this.message = message;
        if(StringUtils.equalsAnyIgnoreCase("success", message)){
            success = true;
        }
    }
}
