package com.whatsapp.api.domain.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Media.
 */
@Data
public class Media{
        @JsonProperty("sha256") String sha256;

        @JsonProperty("mime_type") FileType mimeType;

        @JsonProperty("messaging_product") String messagingProduct;

        @JsonProperty("id") String id;

        @JsonProperty("url") String url;

        @JsonProperty("file_size") long fileSize;
}