package com.whatsapp.api.domain.messages.engaglab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;

/**
 * To send a message, you must first assemble a message object with the content you want to send.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">API documentation - messages</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {
    @JsonProperty("type")
    private MessageType type;
    @JsonProperty("text")
    private TextMessage textMessage;
    @JsonProperty("contacts")
    private List<Contact> contactMessage;
    @JsonProperty("template")
    private TemplateMessage templateMessage;

    @JsonProperty("audio")
    private AudioMessage audioMessage;

    @JsonProperty("document")
    private DocumentMessage documentMessage;

    @JsonProperty("image")
    private ImageMessage imageMessage;

    @JsonProperty("sticker")
    private StickerMessage stickerMessage;

    @JsonProperty("video")
    private VideoMessage videoMessage;


    private Body() {
    }

    private Body(MessageType type) {
        this.type = type;
    }


    /**
     * The type Body builder.
     */
    public static class BodyBuilder {

        private BodyBuilder() {
        }

        /**
         * Builder message builder.
         *
         * @return the message builder
         */
        public static BodyBuilder builder() {
            return new BodyBuilder();
        }


        /**
         * Build a text objetc, with:
         * <ul>
         *     <li><b>body</b> required</li>
         *     <li><b>preview_url</b> optional</li>
         * </ul>
         *
         * @param textMessage : {@link TextMessage} object.
         * @return the message
         */
        public Body buildTextBody(TextMessage textMessage) {
            Body message = new Body(MessageType.TEXT);
            message.textMessage = textMessage;
            return message;


        }

        /**
         * <b>Required</b>.
         * Build an objetc with {@link Contact}
         *
         * @param contactMessage the contact Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#contacts-object">API documentation</a>
         */
        public Body buildContactBody(ContactMessage contactMessage) {
            Body message = new Body(MessageType.CONTACTS);
            message.contactMessage = contactMessage.getContacts();
            return message;

        }

        /**
         * Build template Body
         *
         * @param templateMessage the template Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#template-object">API documentation</a>
         */
        public Body buildTemplateBody(TemplateMessage templateMessage) {
            Body message = new Body(MessageType.TEMPLATE);
            message.templateMessage = templateMessage;
            return message;

        }

        /**
         * Build audio Body
         *
         * @param audioMessage the audio Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Body buildAudioBody(AudioMessage audioMessage) {
            Body message = new Body(MessageType.AUDIO);
            message.audioMessage = audioMessage;
            return message;

        }

        /**
         * Build document Body
         *
         * @param documentMessage the document Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Body buildDocumentBody(DocumentMessage documentMessage) {
            Body message = new Body(MessageType.DOCUMENT);
            message.documentMessage = documentMessage;
            return message;

        }

        /**
         * Build image Body
         *
         * @param imageMessage the image Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Body buildImageBody(ImageMessage imageMessage) {
            Body message = new Body(MessageType.IMAGE);
            message.imageMessage = imageMessage;
            return message;

        }

        /**
         * Build sticker Body
         *
         * @param stickerMessage the sticker Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Body buildStickerBody(StickerMessage stickerMessage) {
            Body message = new Body(MessageType.STICKER);
            message.stickerMessage = stickerMessage;
            return message;

        }

        /**
         * Build video Body
         *
         * @param videoMessage the video Body
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Body buildVideoBody(VideoMessage videoMessage) {
            Body message = new Body(MessageType.VIDEO);
            message.videoMessage = videoMessage;
            return message;

        }


    }

}

