package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Language code
 */
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
    @JsonProperty("code") LanguageType code;
}
