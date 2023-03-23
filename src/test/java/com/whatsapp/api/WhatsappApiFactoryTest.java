package com.whatsapp.api;

import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhatsappApiFactoryTest {

    /**
     * Method under test: {@link WhatsappApiFactory#newBusinessCloudApi(String token))}
     */
    @Test
    void testNewBusinessCloudApi() {

        WhatsappBusinessCloudApi wapi = WhatsappApiFactory.newInstance().newBusinessCloudApi("Api Key");

        Assertions.assertNotNull(wapi);

    }

    /**
     * Method under test: {@link WhatsappApiFactory#newBusinessManagementApi(String token)}
     */
    @Test
    void testNewBusinessManagementApi() {

        WhatsappBusinessManagementApi wapi = WhatsappApiFactory.newInstance().newBusinessManagementApi("Api Key");

        Assertions.assertNotNull(wapi);
    }
}

