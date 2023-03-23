package com.whatsapp.api.domain.media;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @param fileName file name
 * @param content  file content
 */
@AllArgsConstructor
@Data
public class MediaFile {
    String fileName;
    byte[] content;
}
