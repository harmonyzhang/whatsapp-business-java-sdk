package com.whatsapp.api.domain.templates.type;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Only applies to the HEADER type.
 */
public enum HeaderFormat {
    /**
     * Text header format.
     */
    TEXT,
    text,
    /**
     * Image header format.
     */
    IMAGE,
    image,
    /**
     * Document header format.
     */
    DOCUMENT,
    document,
    /**
     * Video header format.
     */
    VIDEO,
    video
}
