package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.engaglab.type.EventType;
import lombok.Data;

@Data
public class Response {

    @JsonProperty("event") EventType event;

    @JsonProperty("response_data") ResponseData data;

}
