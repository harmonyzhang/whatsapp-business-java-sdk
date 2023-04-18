package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SelectEvents {

    /**
     * 消息状态事件
     */
    @JsonProperty("status") List<String> status;

    /**
     * 消息响应事件
     */
    @JsonProperty("response") List<String> response;


}
