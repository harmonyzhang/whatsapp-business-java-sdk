package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Verify code.
 */
@AllArgsConstructor
@Data
public class VerifyCode{
    @JsonProperty("code") String code;
}