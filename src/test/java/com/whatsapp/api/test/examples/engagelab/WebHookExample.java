package com.whatsapp.api.test.examples.engagelab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whatsapp.api.domain.webhook.engaglab.WebHook;
import com.whatsapp.api.domain.webhook.engaglab.WebHookEvent;

import java.io.IOException;

public class WebHookExample {

    public static void main(String[] args) throws IOException {
        messageStatusWebHook();
        newMessageWebHook();
        addWabaWebHook();
    }

    /**
     * 发送消息状态回调
     * @throws JsonProcessingException
     */
    private static void messageStatusWebHook() throws JsonProcessingException {
        // text message paylod
        String payload = "{\n" +
                "    \"total\":1,\n" +
                "    \"rows\":[\n" +
                "        {\n" +
                "            \"message_id\":\"1666165485030094861\",\n" +
                "            \"from\":\"\",\n" +
                "            \"to\":\"\",\n" +
                "            \"server\":\"whatsapp\",\n" +
                "            \"channel\":\"whatsapp\",\n" +
                "            \"itime\":1640707579,\n" +
                "            \"custom_args\":{\n" +
                "\n" +
                "            },\n" +
                "            \"status\":{\n" +
                "                \"message_status\":\"delivered\",\n" +
                "                \"status_data\":{\n" +
                "                    \"msg_time\":1663432355,\n" +
                "                    \"channel_message_id\":\"wamid.123321abcdefed==\",\n" +
                "                    \"whatsapp_business_account_id\":\"\",\n" +
                "                    \"timezone\":\"\",\n" +
                "                    \"plan_user_total\":2007,\n" +
                "                    \"country_code\":\"CN\",\n" +
                "                    \"from_phone_id\":\"111111\",\n" +
                "                    \"conversation\":{\n" +
                "                        \"id\":\"ebe2398cdaa37a0899ca5268b987b0c8\",\n" +
                "                        \"origin\":{\n" +
                "                            \"type\":\"business_initiated\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"pricing\":{\n" +
                "                        \"pricing_model\":\"CBP\",\n" +
                "                        \"category\":\"business_initiated\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"error_code\":0,\n" +
                "                \"error_detail\":{\n" +
                "                    \"message\":\"\"\n" +
                "                },\n" +
                "                \"loss\":{\n" +
                "                    \"loss_step\":1,\n" +
                "                    \"loss_source\":\"aa\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        WebHookEvent event = WebHook.constructEvent(payload);

        System.out.println(event);
    }

    /**
     * 新消息回调
     * @throws JsonProcessingException
     */
    private static void newMessageWebHook() throws JsonProcessingException {
        String payload = "{\n" +
                "    \"total\":1,\n" +
                "    \"rows\":[\n" +
                "        {\n" +
                "            \"message_id\":\"1666165485030094861\",\n" +
                "            \"from\":\"\",\n" +
                "            \"to\":\"\",\n" +
                "            \"server\":\"whatsapp\",\n" +
                "            \"channel\":\"whatsapp\",\n" +
                "            \"itime\":1640707579,\n" +
                "            \"response\":{\n" +
                "                \"event\":\"received\",\n" +
                "                \"response_data\":{\n" +
                "                    \"channel_message_id\":\"wamid.123321abcdefed==\",\n" +
                "                    \"whatsapp_business_account_id\":\"123321\",\n" +
                "                    \"contact\":{\n" +
                "                        \"profile\":{\n" +
                "                            \"name\":\"bob\"\n" +
                "                        },\n" +
                "                        \"wa_id\":\"8613800138000\"\n" +
                "                    },\n" +
                "                    \"message\":{\n" +
                "                        \"type\":\"text\",\n" +
                "                        \"text\":{\n" +
                "                            \"body\":\"here is the message content text\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        WebHookEvent event = WebHook.constructEvent(payload);

        System.out.println(event);
    }

    /**
     * 通过BSP嵌入式流程自动添加 WABA 结果回调
     * @throws JsonProcessingException
     */
    private static void addWabaWebHook() throws JsonProcessingException {
        String payload = "{\n" +
                "    \"total\":1,\n" +
                "    \"rows\":[\n" +
                "        {\n" +
                "            \"server\":\"whatsapp\",\n" +
                "            \"channel\":\"whatsapp\",\n" +
                "            \"itime\":1640707579,\n" +
                "            \"notification\":{\n" +
                "                \"event\":\"whatsapp_bsp_add_waba\",\n" +
                "                \"notification_data\":{\n" +
                "                    \"org_id\":\"123\",\n" +
                "                    \"wabalist\":[\n" +
                "                        {\n" +
                "                            \"waba_id\":\"xxx\",\n" +
                "                            \"waba_name\":\"xxx\",\n" +
                "                            \"phone_list\":[\n" +
                "                                {\n" +
                "                                    \"display_phone_number\":\"+86 133333333\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"display_phone_number\":\"+86 133333333\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"code\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"waba_id\":\"xxx2\",\n" +
                "                            \"waba_name\":\"xxx2\",\n" +
                "                            \"phone_list\":[\n" +
                "                                {\n" +
                "                                    \"number_id\":\"xxx2\",\n" +
                "                                    \"display_phone_number\":\"+86 155555555\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"code\":3001,\n" +
                "                            \"message\":\"WhatsApp 商业账号已被其他组织（***）绑定\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        WebHookEvent event = WebHook.constructEvent(payload);

        System.out.println(event);
    }

}
