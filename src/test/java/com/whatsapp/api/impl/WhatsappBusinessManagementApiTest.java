package com.whatsapp.api.impl;

import com.whatsapp.api.MockServerUtilsTest;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.phone.type.CodeMethodType;
import com.whatsapp.api.domain.phone.type.NameStatusType;
import com.whatsapp.api.domain.phone.type.QualityRatingType;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.ButtonComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.FooterComponent;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.QuickReplyButton;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.utils.Formatter;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;
import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;

class WhatsappBusinessManagementApiTest extends MockServerUtilsTest {


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));


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

        Template response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.getId());
        Assertions.assertEquals("REJECTED", response.getStatus());
        Assertions.assertEquals(Category.TRANSACTIONAL, response.getCategory());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#updateMessageTemplate(String, String, MessageTemplate)}
     */
    @Test
    void testUpdateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

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

        Template response = whatsappBusinessCloudApi.updateMessageTemplate(WABA_ID, "952305634123456", template);

        Assertions.assertEquals("952305634123456", response.getId());
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#deleteMessageTemplate(String, String)}
     */
    @Test
    void testDeleteMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/deleteTemplate.json")));

        Response resp = whatsappBusinessCloudApi.deleteMessageTemplate(WABA_ID, "welcome_template");

        Assertions.assertTrue(resp.isSuccess());

    }


    @Test
    void testCreateMessageTemplate2() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

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

        Template response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.getId());
    }


    @Test
    void testCreateMessageTemplate3() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

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

        Template response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.getId());
    }

    @Test
    void testCreateMessageTemplate4() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

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

        Template response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.getId());
    }


    @Test
    void testRetrieveMessageTemplate1() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate1.json")));

        MessageTemplates templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID);


        Assertions.assertEquals(7, templates.getData().size());
        Assertions.assertEquals("welcome_template3", templates.getData().get(0).getName());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.getData().get(0).getComponents().get(1).getText());
        Assertions.assertEquals("1772832833109192", templates.getData().get(6).getId());

    }

    @Test
    void testRetrieveMessageTemplate2() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate2.json")));

        MessageTemplates templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, 2);


        Assertions.assertEquals(2, templates.getData().size());
        Assertions.assertEquals("welcome_template3", templates.getData().get(0).getName());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.getData().get(0).getComponents().get(1).getText());
        Assertions.assertEquals("https://graph.facebook.com/v15.0/0000000000/message_templates?limit=2&after=MQZDZD", templates.getPaging().getNext());

    }

    @Test
    void testRetrieveMessageTemplate3() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TOKEN);
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate3.json")));

        MessageTemplates templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, "welcome_template3");


        Assertions.assertEquals(1, templates.getData().size());
        Assertions.assertEquals("welcome_template3", templates.getData().get(0).getName());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.getData().get(0).getComponents().get(1).getText());

    }

    @Test
    void testRetrievePhoneNumber() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneNumber.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        PhoneNumber phoneNumber = businessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID, recordedRequest.getPath());

        Assertions.assertEquals("11111111111", phoneNumber.getDisplayPhoneNumber());
        Assertions.assertNull(phoneNumber.getNameStatus());
        Assertions.assertEquals(QualityRatingType.GREEN, phoneNumber.getQualityRating());
        Assertions.assertEquals("NOT_VERIFIED", phoneNumber.getCodeVerificationStatus());
        Assertions.assertEquals("109219645287979", phoneNumber.getId());

    }

    @Test
    void testRetrievePhoneNumberWithSpecificFields() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneWithSpecificFields.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        PhoneNumber phoneNumber = businessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID, "name_status", "verified_name");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "?fields=name_status%2Cverified_name", recordedRequest.getPath());

        Assertions.assertNull(phoneNumber.getDisplayPhoneNumber());
        Assertions.assertEquals(NameStatusType.APPROVED, phoneNumber.getNameStatus());
        Assertions.assertEquals("Test Number", phoneNumber.getVerifiedName());

        Assertions.assertEquals("109219645287979", phoneNumber.getId());

    }

    @Test
    void testRetrievePhoneNumbers() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneNumbersList.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        PhoneNumbers phoneNumbers = businessManagementApi.retrievePhoneNumbers(WABA_ID);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/phone_numbers", recordedRequest.getPath());

        Assertions.assertNotNull(phoneNumbers.getData());
        Assertions.assertNotNull(phoneNumbers.getPaging());

        Assertions.assertEquals(4, phoneNumbers.getData().size());

        PhoneNumber phoneNumber = phoneNumbers.getData().get(0);

        Assertions.assertEquals("1111111111", phoneNumber.getDisplayPhoneNumber());
        Assertions.assertNull(phoneNumber.getNameStatus());
        Assertions.assertEquals(QualityRatingType.YELLOW, phoneNumber.getQualityRating());
        Assertions.assertEquals("NOT_VERIFIED", phoneNumber.getCodeVerificationStatus());
        Assertions.assertEquals("109219652874979", phoneNumber.getId());

    }

    @Test
    void testRetrievePhoneNumberNotFoundError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/phoneNumberNotFoundError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        WhatsappApiException ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.retrievePhoneNumber("454545"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + "454545", recordedRequest.getPath());

        Assertions.assertEquals("Unsupported get request. Object with ID '454545' does not exist, cannot be loaded due to missing permissions, or does not support this operation. Please read the Graph API documentation at https://developers.facebook.com/docs/graph-api", ex.getMessage());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#requestCode(String, RequestCode)}}
     */
    @Test
    void requestCode() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        Response reponse = businessManagementApi.requestCode(PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/request_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code_method\":\"SMS\",\"language\":\"en_US\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertTrue(reponse.isSuccess());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#requestCode(String, RequestCode)}}
     */
    @Test
    void requestCodeError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/requestCodeError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        WhatsappApiException ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.requestCode(PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US)));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/request_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code_method\":\"SMS\",\"language\":\"en_US\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("Request code error | Tente novamente depois de um tempo.", ex.getMessage());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#verifyCode(String, VerifyCode)}
     */
    @Test
    void verifyCode() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        Response reponse = businessManagementApi.verifyCode(PHONE_NUMBER_ID, new VerifyCode("12345678"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/verify_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code\":\"12345678\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertTrue(reponse.isSuccess());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#verifyCode(String, VerifyCode)}
     */
    @Test
    void verifyCodeError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/verifyCodeError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi(TOKEN);

        WhatsappApiException ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.verifyCode(PHONE_NUMBER_ID, new VerifyCode("12345678")));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/verify_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code\":\"12345678\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("Verify code error | O código inserido está incorreto.", ex.getMessage());

    }

}

