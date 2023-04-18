package com.whatsapp.api.domain.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Apikeys {

    /**
     * 组织id
     */
    @JsonProperty("org_id") String orgId;

    /**
     * whatsapp 商业账户的编号
     */
    @JsonProperty("waba_id") String wabaId;

    /**
     * API 秘钥的描述信息
     */
    @JsonProperty("description") String description;

    /**
     * 设置该 API 秘钥允许使用的发送号列表，如果完全不允许使用 Message API，则不要设置该信息，或值为空
     */
    @JsonProperty("message_api_phone_list") List<String> phoneList;

    /**
     * 设置该 API 秘钥是否允许使用模板 API，true：开启，false：关闭（默认）
     */
    @JsonProperty("template_api") boolean templateApi = true;

    /**
     * IP 白名单列表，设置后代表仅这些 IP 地址才能使用该 API 秘钥，默认不控制。
     */
    @JsonProperty("ip_white_list") List<String> ipWhiteList;

    /**
     * 有效日期，时间戳，精确到秒
     */
    @JsonProperty("valid_time") long validTime;


}
