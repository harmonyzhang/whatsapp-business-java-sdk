package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Contact.
 */
@Data
public class Contact {

        @JsonProperty("profile") Profile profile;

        @JsonProperty("name") Name name;

        @JsonProperty("phones") List<Phone> phones;

        @JsonProperty("wa_id") String waId;

}