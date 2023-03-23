package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;
import lombok.Data;

import java.util.List;

/**
 * The type Message templates.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageTemplates{
    @JsonProperty("data") List<Template> data;

    @JsonProperty("paging") Paging paging;
}