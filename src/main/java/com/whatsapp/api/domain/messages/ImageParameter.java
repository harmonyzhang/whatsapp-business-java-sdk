package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Image parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageParameter extends Parameter {

    @JsonProperty("link")
    private String link;
    @JsonProperty("caption")
    private String caption;


    /**
     * Instantiates a new Image parameter.
     *
     * @param link the link
     * @param caption the caption
     */
    public ImageParameter(String link, String caption) {
        super(ParameterType.IMAGE);
        this.link = link;
        this.caption = caption;
    }

    public String getLink() {
        return link;
    }

    public String getCaption() {
        return caption;
    }

}
