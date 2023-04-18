package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The type Webhook.
 * Use this class to deserialize webhook events
 */
public final class WebHook {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Construct WebHookEvent object
     *
     * @param payload the webhook payload json sent by Whatsapp
     * @return an  WebHookEvent instance
     * @throws JsonProcessingException JsonProcessingException if deserialization fails.
     */
    public static WebHookEvent constructEvent(String payload) throws JsonProcessingException {
        return mapper.readValue(payload, WebHookEvent.class);

    }

}
