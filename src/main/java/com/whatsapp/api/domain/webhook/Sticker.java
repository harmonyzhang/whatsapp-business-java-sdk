package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Sticker.
 */
@Data
public class Sticker{
    @JsonProperty("sha256") String sha256;

    @JsonProperty("mime_type") String mimeType;

    @JsonProperty("id") String id;

    @JsonProperty("animated") boolean animated;
}