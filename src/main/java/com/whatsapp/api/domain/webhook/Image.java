package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Image.
 */
@Data
public class Image{

        @JsonProperty("sha256") String sha256;

        @JsonProperty("mime_type") String mimeType;

        @JsonProperty("caption") String caption;

        @JsonProperty("id") String id;
}