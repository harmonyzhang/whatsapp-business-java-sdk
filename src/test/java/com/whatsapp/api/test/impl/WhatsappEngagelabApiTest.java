package com.whatsapp.api.test.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.domain.templates.response.MediaHandlesResponse;
import com.whatsapp.api.test.MockServerUtilsTest;
import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.Component;
import com.whatsapp.api.domain.messages.engaglab.Body;
import com.whatsapp.api.domain.messages.engaglab.Message;
import com.whatsapp.api.domain.messages.engaglab.response.MessageResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.*;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.ComponentType;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.utils.Formatter;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WhatsappEngagelabApiTest extends MockServerUtilsTest {

    @Test
    void testSendMessageError() throws InterruptedException, JsonProcessingException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(500).setBody("{\n" +
                "\t\"code\": 3002,\n" +
                "\t\"message\": \"whatsapp.template field must be set correctly when type is template\"\n" +
                "}"));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Map<String, Object> customArgs = new HashMap<>();
        customArgs.put("a", "test1");

        String requestId = "engagelabid.1122";

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1)) //
                .setRequestId(requestId) // 自定义的请求 ID，用来标识是哪条请求，响应时返回。
                .setCustomArgs(customArgs) // 自定义的信息，在消息状态回调中返回给开发者。
                .buildMessage(Body.BodyBuilder.builder().buildTextBody(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false)));


        WhatsappApiException ex = Assertions.assertThrows(WhatsappApiException.class, () -> whatsappEngagelabApi.sendMessage(message));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"text\",\"text\":{\"preview_url\":false,\"body\":\"*Hello world!*\\nSome code here: \\n```hello world code here```\"}},\"request_id\":\"%s\",\"custom_args\":%s}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1)), requestId, new ObjectMapper().writeValueAsString(customArgs)), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("3002 | whatsapp.template field must be set correctly when type is template", ex.getMessage());
    }

    @Test
    void testSendTextMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Map<String, Object> customArgs = new HashMap<>();
        customArgs.put("a", "test1");

        String requestId = "engagelabid.1122";

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1)) //
                .setRequestId(requestId) // 自定义的请求 ID，用来标识是哪条请求，响应时返回。
                .setCustomArgs(customArgs) // 自定义的信息，在消息状态回调中返回给开发者。
                .buildMessage(Body.BodyBuilder.builder().buildTextBody(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false)));


        com.whatsapp.api.domain.messages.engaglab.response.MessageResponse messageResponse = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"text\",\"text\":{\"preview_url\":false,\"body\":\"*Hello world!*\\nSome code here: \\n```hello world code here```\"}},\"request_id\":\"%s\",\"custom_args\":%s}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1)), requestId, new ObjectMapper().writeValueAsString(customArgs)), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", messageResponse.getMessageId());

        Assertions.assertEquals(requestId, messageResponse.getRequestId());
    }

    @Test
    void testSendTemplateTextMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Message message = com.whatsapp.api.domain.messages.engaglab.Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(com.whatsapp.api.domain.messages.engaglab.Body.BodyBuilder.builder().buildTemplateBody(new com.whatsapp.api.domain.messages.engaglab.TemplateMessage()//
                        .setLanguage(LanguageType.EN).setName("marketinguse")//
                        .addComponent( //
                                new Component(ComponentType.HEADER)//
                                        .addParameter(new TextParameter("order no: 13232332")//
                                        ))));

        whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        String expectedBody = "{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"template\",\"template\":{\"components\":[{\"type\":\"HEADER\",\"parameters\":[{\"type\":\"text\",\"text\":\"order no: 13232332\"}]}],\"name\":\"marketinguse\",\"language\":\"en\"}}}";

        Assertions.assertEquals(String.format(expectedBody,TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

    }


    @Test
    void testSendAudioMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        AudioMessage audioMessage = new AudioMessage()//
                //.setId("6418001414900549");
                .setLink("https://file-examples.com/storage/fe5947fd2362fc197a3c2df/2017/11/file_example_MP3_700KB.mp3");

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildAudioBody(audioMessage));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"audio\",\"audio\":{\"link\":\"https://file-examples.com/storage/fe5947fd2362fc197a3c2df/2017/11/file_example_MP3_700KB.mp3\"}}}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.getMessageId());
    }

    @Test
    void testSendVideoMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        VideoMessage videoMessage = new VideoMessage()//
                //.setId("1236364143659727")// media id (uploaded before)
                .setLink("https://img.jiguang.cn/jiguang/public/videos/432acc5.mp4")
                .setCaption("See this video");

        com.whatsapp.api.domain.messages.engaglab.Message message = com.whatsapp.api.domain.messages.engaglab.Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildVideoBody(videoMessage));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"video\",\"video\":{\"link\":\"https://img.jiguang.cn/jiguang/public/videos/432acc5.mp4\",\"caption\":\"See this video\"}}}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.getMessageId());
    }

    @Test
    void testSendImageMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        ImageMessage imageMessage = new ImageMessage()//
                .setLink("https://res.theengagelab.com/console/core/img/engagelab.7df2c538.svg")
                .setCaption("See this image, please");

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildImageBody(imageMessage));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"image\",\"image\":{\"link\":\"https://res.theengagelab.com/console/core/img/engagelab.7df2c538.svg\",\"caption\":\"See this image, please\"}}}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.getMessageId());
    }

    @Test
    void testSendDocumentMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        DocumentMessage documentMessage = new DocumentMessage()//
                //.setId("1238834210396519")// media id (uploaded before)
                .setLink("https://img.jiguang.cn/jiguang/public/videos/432acc5.mp4")
                .setCaption("zhanglexianng")//
                .setFileName("hello.mp4");

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildDocumentBody(documentMessage));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"document\",\"document\":{\"link\":\"https://img.jiguang.cn/jiguang/public/videos/432acc5.mp4\",\"caption\":\"zhanglexianng\",\"filename\":\"hello.mp4\"}}}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.getMessageId());
    }

    @Test
    void testSendStickerMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        StickerMessage stickerMessage = new StickerMessage()//
                //.setId("527984052814860");// media id (uploaded before)
                .setLink("http://sample-file.bazadanni.com/download/images/webp/sample.webp");

        Message message = Message.MessageBuilder.builder()//
                .setFrom(TestConstants.PHONE_NUMBER_ID)
                .setTo(Arrays.asList(TestConstants.PHONE_NUMBER_1))
                .buildMessage(Body.BodyBuilder.builder().buildStickerBody(stickerMessage));

        MessageResponse response = whatsappEngagelabApi.sendMessage(message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_API_VERSION + "/" + "messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"from\":\"%s\",\"to\":%s,\"body\":{\"type\":\"sticker\",\"sticker\":{\"link\":\"http://sample-file.bazadanni.com/download/images/webp/sample.webp\"}}}",TestConstants.PHONE_NUMBER_ID, new ObjectMapper().writeValueAsString(Arrays.asList(TestConstants.PHONE_NUMBER_1))), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("engagelabid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.getMessageId());
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/template.json")));

        MessageTemplate template = new MessageTemplate();

        template.setName("welcome_template2")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "s")//
                        ))//


        ;

        MessageTemplateIDResponse response = whatsappEngagelabApi.createMessageTemplate(template);

        Assertions.assertEquals("952305634123456", response.getId());

    }

    @Test
    void testCreateMessageTemplate2() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/template.json")));

        MessageTemplate template = new MessageTemplate();

        template.setName("number_confirmation")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Código de confirmação")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Este é o seu código de confirmação: " + Formatter.bold("{{1}}."))//
                        .setExample(new Example()//
                                .addBodyTextExamples("1458425")//
                        ))//
                .addComponent(new FooterComponent().setText("Use este código para confirmar seu telefone."))


        ;

        MessageTemplateIDResponse response = whatsappEngagelabApi.createMessageTemplate(template);

        Assertions.assertEquals("952305634123456", response.getId());
    }


    @Test
    void testCreateMessageTemplate3() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/template.json")));

        MessageTemplate template = new MessageTemplate();

        template.setName("schedule_confirmation3")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Confirmação de Atendimento")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria", "04/11/2022", "13:30")//
                        ))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//
                        .addButton(new QuickReplyButton("REMARCAR")//
                        )


                )//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


        ;

        MessageTemplateIDResponse response = whatsappEngagelabApi.createMessageTemplate(template);

        Assertions.assertEquals("952305634123456", response.getId());
    }

    @Test
    void testCreateMessageTemplate4() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/template.json")));

        MessageTemplate template = new MessageTemplate();

        template.setName("schedule_confirmation5")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Confirmação de Atendimento")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria", "04/11/2022", "13:30")//
                        ))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//


                )//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


        ;

        MessageTemplateIDResponse response = whatsappEngagelabApi.createMessageTemplate(template);

        Assertions.assertEquals("952305634123456", response.getId());
    }


    @Test
    void testRetrieveMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/retTemplate.json")));

        List<Template> templates = whatsappEngagelabApi.retrieveTemplates();

        Assertions.assertEquals(3, templates.size());
        Assertions.assertEquals("test", templates.get(0).getName());
        Assertions.assertEquals("Edit template", templates.get(0).getComponents().get(1).getText());
        Assertions.assertEquals("543212167937369", templates.get(0).getId());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#updateMessageTemplate(String, String, MessageTemplate)}
     */
    @Test
    void testUpdateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/updateTemplate.json")));

        MessageTemplate template = new MessageTemplate();

        template.setName("welcome_template")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "satisfaction")//
                        ))//


        ;

        Response response = whatsappEngagelabApi.updateMessageTemplate("952305634123456", template);

        Assertions.assertTrue(response.isSuccess());
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#deleteMessageTemplate(String, String)}
     */
    @Test
    void testDeleteMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/deleteTemplate.json")));

        Response response = whatsappEngagelabApi.deleteMessageTemplate("welcome_template");

        Assertions.assertTrue(response.isSuccess());

    }


    /**
     * Method under test: {@link WhatsappEngagelabApi#mediaHandles(File)}
     */
    @Test
    void testMediaHandles() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/engagelab/mediaHandles.json")));
        String path = this.getClass().getResource("/starwars.png").getPath();
        File file = new File(path);
        MediaHandlesResponse mediaHandlesResponse = whatsappEngagelabApi.mediaHandles(file);

        Assertions.assertEquals("4::aW1hZ2UvanBlZw==:ARb2JGd8LbvJbfmpMASFAlczcn4hxLC6tkwjasjD4WL6_i34tIisq0IdWNFFFj1KwJMRXPU4xwygHSJd4DHu1f19LcBBl2qeb8EuEcgnIUPYIQ:e:1682169041:4985146461608173:100084026087657:ARazr9kxfzKshJE4WpY", mediaHandlesResponse.getHandleId());

    }



}

