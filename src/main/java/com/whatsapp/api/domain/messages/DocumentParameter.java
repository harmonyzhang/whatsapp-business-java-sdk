package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Document parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentParameter extends Parameter {

    @JsonProperty("link")
    private String link;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("filename")
    private String filename;


    /**
     * Instantiates a new Document parameter.
     *
     * @param link the link
     * @param caption the caption
     * @param filename the filename
     */
    public DocumentParameter(String link, String caption, String filename) {
        super(ParameterType.IMAGE);
        this.link = link;
        this.caption = caption;
        this.filename = filename;
    }

    public String getLink() {
        return link;
    }

    public String getCaption() {
        return caption;
    }

    public String getFilename() {
        return filename;
    }
}
