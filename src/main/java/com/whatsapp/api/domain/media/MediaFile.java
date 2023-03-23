package com.whatsapp.api.domain.media;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * MediaFile
 */
@AllArgsConstructor
@Data
public class MediaFile {
    String fileName;
    byte[] content;
}
