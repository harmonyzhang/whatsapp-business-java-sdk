package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Metadata.
 */
@Data
public class Metadata{
        /*
        The ID of the phone number receiving the Webhooks. You can use this phone_number_id to send messages back to customers.
         */
        @JsonProperty("phone_number_id") String phoneNumberId;
        /*
        The phone number of the business account that is receiving the Webhooks.
         */
        @JsonProperty("display_phone_number") String displayPhoneNumber;
}