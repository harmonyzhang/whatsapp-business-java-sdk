package com.whatsapp.api.test.domain.webhook;

import com.whatsapp.api.test.TestUtils;
import com.whatsapp.api.domain.messages.type.MessageType;
import com.whatsapp.api.domain.webhook.Error;
import com.whatsapp.api.domain.webhook.Status;
import com.whatsapp.api.domain.webhook.WebHook;
import com.whatsapp.api.domain.webhook.WebHookEvent;
import com.whatsapp.api.domain.webhook.type.EventType;
import com.whatsapp.api.domain.webhook.type.FieldType;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import com.whatsapp.api.domain.webhook.type.RestrictionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class WebHookPayloadTest extends TestUtils {

    private final String JSON_FOLDER = "/deserialization/";

    @Test
    void testDeserializationTextgetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "textMessage.json");


        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals("hi everyone!", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getText().getBody());
        Assertions.assertEquals(MessageType.TEXT, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());


    }

    @Test
    void testDeserializationTextMessage2() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "textMessage2.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().isEmpty());

        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals("Good afternoon", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getText().getBody());
        Assertions.assertEquals(MessageType.TEXT, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());


    }

    @Test
    void testDeserializationTextMessageSent() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "textMessageStatusSent.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry());
        Assertions.assertFalse(obj.getEntry().isEmpty());
        Assertions.assertNotNull(obj.getEntry().get(0));


        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals(MessageStatus.SENT, obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getStatus());

        Assertions.assertEquals("8eb644d2350611f3746e7f0985bddfc1", obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getConversation().getId());
        Assertions.assertEquals("1673031000", obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getConversation().getExpirationTimestamp());
        Assertions.assertEquals("business_initiated", obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getConversation().getOrigin().getType());


        Assertions.assertTrue(obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getPricing().isBillable());
        Assertions.assertEquals("CBP", obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getPricing().getPricingModel());
        Assertions.assertEquals("business_initiated", obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getPricing().getCategory());


    }

    @Test
    void testDeserializationTextMessageDelivered() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "textMessageStatusDelivered.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry());
        Assertions.assertFalse(obj.getEntry().isEmpty());
        Assertions.assertNotNull(obj.getEntry().get(0));
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().isEmpty());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().isEmpty());


        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals(MessageStatus.DELIVERED, obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getStatus());


    }

    @Test
    void testDeserializationTextMessageRead() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "textMessageStatusRead.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry());
        Assertions.assertFalse(obj.getEntry().isEmpty());
        Assertions.assertNotNull(obj.getEntry().get(0));
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().isEmpty());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().isEmpty());


        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals(MessageStatus.READ, obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0).getStatus());


    }

    @Test
    void testDeserializationButtongetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "buttonMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().isEmpty());

        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getContext());
        Assertions.assertEquals(MessageType.BUTTON, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getButton());

    }


    @Test
    void testDeserializationMessageDeleted() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "messageDeleted.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().isEmpty());


        Assertions.assertEquals(MessageType.UNSUPPORTED, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getErrors());
        Error erro = obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getErrors().get(0);
        Assertions.assertEquals("Message type unknown", erro.getMessage());
        Assertions.assertEquals(131051, erro.getCode());
        Assertions.assertEquals("Message type unknown", erro.getTitle());
        Assertions.assertEquals("Message type is currently not supported.", erro.getErrorData().getDetails());


    }

    @Test
    void testDeserializationReactgetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "reactMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().isEmpty());

        Assertions.assertEquals(1, obj.getEntry().size());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());
        Assertions.assertEquals(1, obj.getEntry().get(0).getChanges().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());

        Assertions.assertEquals(MessageType.REACTION, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getReaction());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getReaction().getMessageId());

    }


    @Test
    void testDeserializationStickergetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "stickerMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("whatsapp_business_account", obj.getObject());
        Assertions.assertFalse(obj.getEntry().isEmpty());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());

        Assertions.assertFalse(obj.getEntry().get(0).getChanges().isEmpty());

        Assertions.assertEquals(MessageType.STICKER, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertEquals("image/webp", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getSticker().getMimeType());
        Assertions.assertFalse(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getSticker().isAnimated());
        Assertions.assertEquals("1604825680670873", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getSticker().getId());

    }

    @Test
    void testDeserializationVideogetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "videoMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("whatsapp_business_account", obj.getObject());
        Assertions.assertFalse(obj.getEntry().isEmpty());
        Assertions.assertEquals("880480571844883", obj.getEntry().get(0).getId());

        Assertions.assertEquals("whatsapp", obj.getEntry().get(0).getChanges().get(0).getValue().getMessagingProduct());
        Assertions.assertEquals("43330585569", obj.getEntry().get(0).getChanges().get(0).getValue().getMetadata().getDisplayPhoneNumber());
        Assertions.assertEquals("409552778964973", obj.getEntry().get(0).getChanges().get(0).getValue().getMetadata().getPhoneNumberId());

        Assertions.assertEquals("1111111111111", obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().get(0).getWaId());
        Assertions.assertEquals("1111111111111", obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().get(0).getWaId());
        Assertions.assertEquals("Mauricio Binda", obj.getEntry().get(0).getChanges().get(0).getValue().getContacts().get(0).getProfile().getName());


        Assertions.assertEquals("1111111111111", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getFrom());
        Assertions.assertEquals("wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNFQjAwQjVGQUFGOEVDMTUyMTJBAA==", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getId());
        Assertions.assertEquals("1673029501", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.VIDEO, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertEquals("video/mp4", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getVideo().getMimeType());
        Assertions.assertEquals("waIq5BBe5GgjT6DHWu3LY9F8jYOZzYLHRRRGDTbipNk=", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getVideo().getSha256());
        Assertions.assertEquals("661828760183585", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getVideo().getId());

    }

    @Test
    void testDeserializationImagegetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "imageMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673032525", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.IMAGE, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertEquals("image/jpeg", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getImage().getMimeType());
        Assertions.assertEquals("ciJuSxU7RLnnFz3cNcasdL7UQKt9e1yj/3u+Rhsabv0=", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getImage().getSha256());
        Assertions.assertEquals("8472976218001204", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getImage().getId());

    }

    @Test
    void testDeserializationAudiogetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "audioMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673033070", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.AUDIO, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertEquals("audio/ogg; codecs=opus", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getAudio().getMimeType());
        Assertions.assertEquals("iWa0+O81ZLcSkZx6n4QAmrWuHpn8HWFX3gB6a3fQtmk=", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getAudio().getSha256());
        Assertions.assertEquals("827776106019109", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getAudio().getId());
        Assertions.assertTrue(obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getAudio().isVoice());

    }

    @Test
    void testDeserializationDocumentgetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "documentMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673034392", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.DOCUMENT, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());
        Assertions.assertEquals("application/pdf", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getDocument().getMimeType());
        Assertions.assertEquals("mu/J5jGsroQM3Tbn4c6StBJG4C4glbTi8gT4jhRHSt0=", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getDocument().getSha256());
        Assertions.assertEquals("848704520347750", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getDocument().getId());
        Assertions.assertEquals("4_641947.pdf", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getDocument().getFilename());

    }

    @Test
    void testDeserializationContactgetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "contactMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673641462", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.CONTACTS, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());

        Assertions.assertEquals("Person", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getContacts().get(0).getName().getFirstName());

    }

    @Test
    void testDeserializationLocationgetMessage() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "locationMessage.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673641462", obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getTimestamp());
        Assertions.assertEquals(MessageType.LOCATION, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getType());

        Assertions.assertEquals(-10.93941311633, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getLocation().getLatitude());
        Assertions.assertEquals(-10.606395436721, obj.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getLocation().getLongitude());

    }

    @Test
    void testDeserializationVerifiedAccount() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "verifiedAccount.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(EventType.VERIFIED_ACCOUNT, obj.getEntry().get(0).getChanges().get(0).getValue().getEvent());
        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());


    }

    @Test
    void testDeserializationRejectedTemplate() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "rejectedTemplate.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(EventType.REJECTED, obj.getEntry().get(0).getChanges().get(0).getValue().getEvent());
        Assertions.assertEquals("905507062668800", obj.getEntry().get(0).getChanges().get(0).getValue().getMessageTemplateId());
        Assertions.assertEquals(FieldType.MESSAGE_TEMPLATE_STATUS_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());

    }

    @Test
    void testDeserializationPhoneNumberNameUpdate() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "phoneNumberNameUpdate.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.PHONE_NUMBER_NAME_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());

        Assertions.assertEquals("APPROVED", obj.getEntry().get(0).getChanges().get(0).getValue().getDecision());
        Assertions.assertEquals("WhatsApp", obj.getEntry().get(0).getChanges().get(0).getValue().getRequestedVerifiedName());

    }

    @Test
    void testDeserializationTemplateSchedulingForDisabling() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "templateSchedulingForDisabling.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.MESSAGE_TEMPLATE_STATUS_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());

        Assertions.assertEquals(EventType.FLAGGED, obj.getEntry().get(0).getChanges().get(0).getValue().getEvent());
        Assertions.assertEquals("My message template", obj.getEntry().get(0).getChanges().get(0).getValue().getMessageTemplateName());


    }

    @Test
    void testDeserializationQualityUpdate() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "qualityUpdate.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.PHONE_NUMBER_QUALITY_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());


    }

    @Test
    void testDeserializationAccountBanned() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "accountBanned.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertNotNull(obj.getEntry().get(0).getChanges().get(0).getValue().getBanInfo());
    }

    @Test
    void testDeserializationAccountReview() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "accountReview.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_REVIEW_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());
    }

    @Test
    void testDeserializationAccountRestricted() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "accountRestricted.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.getEntry().get(0).getChanges().get(0).getField());
        Assertions.assertEquals(RestrictionType.RESTRICTED_ADD_PHONE_NUMBER_ACTION, obj.getEntry().get(0).getChanges().get(0).getValue().getRestrictionInfo().get(0).getRestrictionType());
    }

    @Test
    void testDeserializationMediaUploadError() throws IOException, URISyntaxException {
        String payload = fromResource(JSON_FOLDER + "mediaUploadError.json");

        WebHookEvent obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.MESSAGES, obj.getEntry().get(0).getChanges().get(0).getField());

        List<Status> statuses = obj.getEntry().get(0).getChanges().get(0).getValue().getStatuses();

        Assertions.assertNotNull(statuses);

        Assertions.assertEquals(131053, statuses.get(0).getErrors().get(0).getCode());
        Assertions.assertEquals("Media upload error", statuses.get(0).getErrors().get(0).getTitle());
        Assertions.assertEquals("Media upload error", statuses.get(0).getErrors().get(0).getMessage());
        Assertions.assertEquals("Unsupported Video mime type text/html. Please use one of video/3gpp, video/mp4.", statuses.get(0).getErrors().get(0).getErrorData().getDetails());
    }
}

