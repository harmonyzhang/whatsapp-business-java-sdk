package com.whatsapp.api.domain.messages.engaglab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;
import java.util.Map;

/**
 * To send a message, you must first assemble a message object with the content you want to send.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">API documentation - messages</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private List<String> to;
    @JsonProperty("body")
    private Body body;

    @JsonProperty("request_id") String requestId;

    @JsonProperty("custom_args")
    private Map<String, Object> customArgs;

    private Message() {
    }

    private Message(String from, List<String> to, Body body, String requestId, Map<String, Object> customArgs) {
        this.from = from;
        this.to = to;
        this.body = body;
        this.requestId = requestId;
        this.customArgs = customArgs;
    }

    /**
     * The type Message builder.
     */
    public static class MessageBuilder {

        private String from;
        private List<String> to;
        private String requestId;
        private Map<String, Object> customArgs;


        private MessageBuilder() {
        }

        /**
         * Builder message builder.
         *
         * @return the message builder
         */
        public static MessageBuilder builder() {
            return new MessageBuilder();
        }

        /**
         * Sets from.
         *
         * @param from Required.           <p>           WhatsApp ID or phone number for the person you want to send a message to.
         * @return the to
         */
        public MessageBuilder setFrom(String from) {
            this.from = from;
            return this;
        }

        /**
         * Sets to.
         *
         * @param to Required.           <p>           WhatsApp ID or phone number for the person you want to send a message to.
         * @return the to
         */
        public MessageBuilder setTo(List<String> to) {
            this.to = to;
            return this;
        }

        public MessageBuilder setRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public MessageBuilder setCustomArgs(Map<String, Object> customArgs) {
            this.customArgs = customArgs;
            return this;
        }

        /**
         * Build a text objetc, with:
         * <ul>
         *     <li><b>body</b> required</li>
         *     <li><b>preview_url</b> optional</li>
         * </ul>
         *
         * @param body : {@link Body} object.
         * @return the message
         */
        public Message buildMessage(Body body) {
            Message message = new Message(from, to, body, requestId, customArgs);
            return message;

        }

    }

}

