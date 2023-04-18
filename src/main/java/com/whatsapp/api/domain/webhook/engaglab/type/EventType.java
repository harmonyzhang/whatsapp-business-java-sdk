package com.whatsapp.api.domain.webhook.engaglab.type;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used when an event happened in a specific EngageLab.
 * See <a href="https://jiguang-docs.yuque.com/te6n14/whatsapp.engagelab/seqze9t8egu6gcn8#xU8Rx">Webhooks Components</a>
 */
public enum EventType {

    /**
     * 收到用户的消息.
     * 用户直接发送了一条消息
     */
    @JsonProperty("received")
    RECEIVED, //
    /**
     * 用户回复了你的消息.
     * 企业先发送了消息给用户，用户选择对该条信息进行回复
     */
    @JsonProperty("reply")
    REPLY,//
    /**
     * 用户下订单
     */
    @JsonProperty("order")
    ORDER,//

    /**
     * 用户删除了他的消息
     * 用户将自己发出的消息删除了（待上线）
     */
    @JsonProperty("deleted")
    DELETED

}
