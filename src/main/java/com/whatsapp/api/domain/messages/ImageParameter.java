package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Image parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageParameter extends Parameter {

    @JsonProperty("image")
    private Media image;

    /**
     * Instantiates a new Image parameter.
     *
     * @param image image
     */
    public ImageParameter(Media image) {
        super(ParameterType.IMAGE);
        this.image = image;
    }

    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }
}
