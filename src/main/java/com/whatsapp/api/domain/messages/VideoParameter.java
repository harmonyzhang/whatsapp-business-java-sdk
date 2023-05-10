package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Video parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoParameter extends Parameter {

    @JsonProperty("link")
    private String link;
    @JsonProperty("caption")
    private String caption;


    /**
     * Instantiates a new Video parameter.
     *
     * @param link the link
     * @param caption the caption
     */
    public VideoParameter(String link, String caption) {
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
