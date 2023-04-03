package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.engaglab.type.NotificationEventType;
import lombok.Data;

@Data
public class Notification {

    @JsonProperty("event")
    NotificationEventType event;

    @JsonProperty("notification_data") NotificationData data;


}
