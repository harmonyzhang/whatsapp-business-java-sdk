package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Message template id response.
 * @deprecated use {@link com.whatsapp.api.domain.templates.MessageTemplate} instead
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageTemplateIDResponse {
    @JsonProperty("template_id") String id;
}
