package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Contact.
 *
 * @param profile The {@link Profile} object.
 * @param waId    The WhatsApp ID of the customer. You can send messages using this wa_id.
 */
@Data
public class Contact {

        @JsonProperty("profile") Profile profile;

        @JsonProperty("name") Name name;

        @JsonProperty("phones") List<Phone> phones;

        @JsonProperty("wa_id") String waId;

}