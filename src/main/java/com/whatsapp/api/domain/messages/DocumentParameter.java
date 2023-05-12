package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Document parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentParameter extends Parameter {

    @JsonProperty("document")
    private Media document;


    /**
     * Instantiates a new Document parameter.
     *
     * @param document document
     */
    public DocumentParameter(Media document) {
        super(ParameterType.DOCUMENT);
        this.document = document;
    }

    public Media getDocument() {
        return document;
    }

    public void setDocument(Media document) {
        this.document = document;
    }
}
