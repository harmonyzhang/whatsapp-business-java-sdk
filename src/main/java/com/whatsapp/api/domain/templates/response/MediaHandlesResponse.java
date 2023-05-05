package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Classname MediaHandlesResponse
 * @Description TODO
 * @Date 2023/5/5 11:06 AM
 * @Created by guomingwei
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MediaHandlesResponse {
    @JsonProperty("handle_id") String handleId;
}
