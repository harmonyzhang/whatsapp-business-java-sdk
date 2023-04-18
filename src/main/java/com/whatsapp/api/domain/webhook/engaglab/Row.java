package com.whatsapp.api.domain.webhook.engaglab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.Change;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Generic webhook class wrapper. All Webhooks messages have this.
 */
@Data
public class Row {
        /**
            EngageLab 的消息id
        */
        @JsonProperty("message_id") String id;

        /**
         * 发送方
         */
        @JsonProperty("from") String from;

        /**
         * 接收方
         */
        @JsonProperty("to") String to;

        @JsonProperty("server") String server;

        @JsonProperty("channel") String channel;

        /**
         * 消息状态产生的时间戳，如消息已送达的时间
         */
        @JsonProperty("itime") long itime;

        /**
         * 这条消息创建时提交的参数，将于此回调时原样返回
         */
        @JsonProperty("custom_args") Map<String, Object> customArgs;

        @JsonProperty("status") Status status;

        @JsonProperty("response") Response response;

        @JsonProperty("notification") Notification notification;

}