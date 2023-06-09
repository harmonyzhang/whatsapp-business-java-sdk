package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;
import lombok.Data;

import java.util.List;

/**
 * The Object with PhoneNumbers
 */
@Data
public class PhoneNumbers {
    @JsonProperty("data") List<PhoneNumber> data;

    @JsonProperty("paging") Paging paging;
}