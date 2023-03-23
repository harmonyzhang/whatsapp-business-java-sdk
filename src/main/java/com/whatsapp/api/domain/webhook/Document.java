package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * When messages type is set to document, this object is included in the messages object.
 */
@Data
public class Document {

        @JsonProperty("filename") String filename;

        @JsonProperty("mime_type") String mimeType;

        @JsonProperty("sha256") String sha256;

        @JsonProperty("id") String id;

        @JsonProperty("caption") String caption;
}
