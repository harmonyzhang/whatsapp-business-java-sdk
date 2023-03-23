package com.whatsapp.api.test.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;


public class RetrievePhoneNumberExample {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi(TestConstants.TOKEN);

        // one phone number
        retrieveOne(whatsappBusinessManagementApi);

        // one phone number with specifc fields
        retrieveOneWithSpecificFields(whatsappBusinessManagementApi);

        // a list of phone numbers
        retrieveAll(whatsappBusinessManagementApi);

    }

    private static void retrieveOne(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {
        PhoneNumber phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(TestConstants.PHONE_NUMBER_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
    }

    private static void retrieveOneWithSpecificFields(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {

        PhoneNumber phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(TestConstants.PHONE_NUMBER_ID, "name_status", "verified_name");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
    }


    private static void retrieveAll(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {

        PhoneNumbers phoneNumbers = whatsappBusinessManagementApi.retrievePhoneNumbers(TestConstants.WABA_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumbers));
    }


}
