package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(NON_NULL)
public class Media {
    /**
     * Required when type is an image, audio, document, or video and you are not using a link.
     * The media object ID. For more information, see Get Media ID.
     * */
    private String id;
    /**
     * Required when type is audio, document, image, sticker, or video and you are not using an uploaded media ID.
     * The protocol and URL of the media to be sent. Use only with HTTP/HTTPS URLs. caption	Optional.
     */
    private String link;

    /**
     * Describes the specified image, video, or document media. Do not use it with audio media.
     */
    private String caption;

    /**
     *  Describes the filename for the specific document. Use only with document media.
     */
    private String filename;

    /**
     * 是否是语音
     */
    private Boolean voice;

    /**
     * 文件类型
     */
    private String mimeType;
}
