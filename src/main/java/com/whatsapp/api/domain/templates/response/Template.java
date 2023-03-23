package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.Component;
import com.whatsapp.api.domain.templates.type.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * The type Data item.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Template{

    @JsonProperty("components") List<Component<?>> components;

    @JsonProperty("name") String name;

    @JsonProperty("language") String language;

    @JsonProperty("id") String id;

    @JsonProperty("category") Category category;

    @JsonProperty("status") String status;

    @JsonProperty("quality_score") String qualityScore;

    @JsonProperty("updated_time")
    Date updatedTime;




}