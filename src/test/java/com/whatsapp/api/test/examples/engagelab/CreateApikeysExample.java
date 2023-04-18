package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.organization.Apikeys;
import com.whatsapp.api.domain.organization.ApikeysResponse;
import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
import com.whatsapp.api.impl.WhatsappEngagelabBspApi;
import com.whatsapp.api.test.TestConstants;

import java.util.Arrays;
import java.util.Calendar;

public class CreateApikeysExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabBspApi whatsappEngagelabApi = factory.newEngagelabBspApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);

        Apikeys apikeys = new Apikeys();
        apikeys.setOrgId("123");
        apikeys.setWabaId("323233");
        apikeys.setDescription("desc");
        apikeys.setPhoneList(Arrays.asList("232323"));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 2); // 有效期2年
        apikeys.setValidTime(calendar.getTimeInMillis()/1000);

        apikeys.setIpWhiteList(null);

        ApikeysResponse response = whatsappEngagelabApi.createApikeys(apikeys);

        System.out.println(response);
    }

}
