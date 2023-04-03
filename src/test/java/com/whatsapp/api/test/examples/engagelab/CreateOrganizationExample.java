package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.*;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.impl.WhatsappEngagelabBspApi;
import com.whatsapp.api.test.TestConstants;

public class CreateOrganizationExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabBspApi whatsappEngagelabApi = factory.newEngagelabBspApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Organization organization = new Organization();
        organization.setName("test");
        organization.setTimezone("Beijing, Chongqing, Hong Kong, Urumqi");

        OrganizationResponse response = whatsappEngagelabApi.createOrganization(organization);

        System.out.println(response);
    }

}
