package com.whatsapp.api.domain.webhook.type;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Message status.
 */
public enum MessageStatus {
    /**
     * Message received by WhatsApp server. (One checkmark)
     */
    SENT("sent"),
    /**
     * Message delivered to the recipient. (Two checkmarks)
     */
    DELIVERED("delivered"),
    /**
     * Message read by recipient. (Two blue checkmarks)
     */
    READ("read"),

    /**
     * Message failed to send.(Red error triangle)
     */
    FAILED("failed"),
    /**
     * Message deleted by the user. (	Message is replaced in WhatsApp mobile with the note "This message was deleted".)
     */
    DELETED("deleted"),

    /**
     * 发送失败
     */
    SENT_FAILED("sent_failed"),
    /**
     * 该号码提交给 Meta WhatsApp 服务成功，但 Meta 回调告知失败。
     */
    DELIVERED_FAILED("delivered_failed"),
    /**
     * 目标无效
     * 1、该号码被 EngageLab 判定为非法
     * 2、该号码被 Meta WhatsApp 服务判定为非法
     */
    TARGET_INVALID("target_invalid"),
    /**
     * 通过合法性校验
     * 1、该号码被 EngageLab 判定为合法
     * 2、该号码被 Meta WhatsApp 服务判定为合法
     */
    TARGET_VALID("target_valid"),
    /**
     * 该号码在传递的「收件人号码」内，即为该号码记录1个计划发送目标的状态
     */
    PLAN("plan");

    private final String value;

    MessageStatus(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
