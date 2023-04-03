package com.whatsapp.api.test.impl;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
import com.whatsapp.api.impl.WhatsappEngagelabBspApi;
import com.whatsapp.api.test.MockServerUtilsTest;
import com.whatsapp.api.test.TestConstants;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhatsappEngagelabBspApiTest extends MockServerUtilsTest {

    @Test
    void testCreateOrganization() throws InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\n" +
                "  \"org_id\": \"6419507488f7ed0a6a46c13e\"\n" +
                "}"));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabBspApi whatsappEngagelabApi = factory.newEngagelabBspApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Organization organization = new Organization();
        organization.setName("test");
        organization.setTimezone("8");

        OrganizationResponse response = whatsappEngagelabApi.createOrganization(organization);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + WhatsappApiConfig.ENGAGELAB_DEV_API_VERSION + "/" + "organization", recordedRequest.getPath());

        Assertions.assertEquals("6419507488f7ed0a6a46c13e", response.getOrgId());

    }



}

