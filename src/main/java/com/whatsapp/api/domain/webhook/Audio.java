package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Audio.
 *
 * @param sha256   The checksum of the media.
 * @param mimeType The mime type of the media.                 The caption that describes the media.
 * @param id       The ID of the medi
 */
@Data
public class Audio{

        @JsonProperty("mime_type") String mimeType;

        @JsonProperty("sha256") String sha256;

        @JsonProperty("id") String id;

        @JsonProperty("voice") boolean voice;

}
