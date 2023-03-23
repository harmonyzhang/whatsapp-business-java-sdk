package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.EventType;
import lombok.Data;

import java.util.List;

/**
 * The type Value.
 */
@Data
public class Value {
        @JsonProperty("metadata") Metadata metadata;

        @JsonProperty("messaging_product") String messagingProduct;

        @JsonProperty("messages") List<Message> messages;

        @JsonProperty("contacts") List<Contact> contacts;

        @JsonProperty("statuses") List<Status> statuses;

        @JsonProperty("event") EventType event;

        @JsonProperty("phone_number") String phoneNumber;

        @JsonProperty("message_template_id") String messageTemplateId;

        @JsonProperty("message_template_name") String messageTemplateName;

        @JsonProperty("message_template_language") String messageTemplateLanguage;

        @JsonProperty("reason") String reason;

        @JsonProperty("display_phone_number") String displayPhoneNumber;

        @JsonProperty("decision") String decision;

        @JsonProperty("requested_verified_name") String requestedVerifiedName;

        @JsonProperty("rejection_reason") Object rejectionReason;

        @JsonProperty("disable_info") DisableInfo disableInfo;

        @JsonProperty("current_limit") String currentLimit;

        @JsonProperty("ban_info") BanInfo banInfo;

        @JsonProperty("restriction_info") List<RestrictionInfo> restrictionInfo;

}