package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Video parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoParameter extends Parameter {

    @JsonProperty("video")
    private Media video;

    /**
     * Instantiates a new Video parameter.
     *
     * @param video video
     */
    public VideoParameter(Media video) {
        super(ParameterType.VIDEO);
        this.video = video;
    }

    public Media getVideo() {
        return video;
    }

    public void setVideo(Media video) {
        this.video = video;
    }
}
