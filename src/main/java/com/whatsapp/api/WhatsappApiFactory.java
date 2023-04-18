package com.whatsapp.api;


import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.impl.WhatsappEngagelabBspApi;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * A factory for creating Whatsapp api client objects.
 */
public class WhatsappApiFactory {

    private WhatsappApiFactory() {
    }

    /**
     * New instance whatsapp api factory.
     *
     * @return the whatsapp api factory
     */
    public static WhatsappApiFactory newInstance() {
        return new WhatsappApiFactory();
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client
     * @param token the token
     * @return the whatsapp business cloud api
     */
    public WhatsappBusinessCloudApi newBusinessCloudApi(String token) {

        return new WhatsappBusinessCloudApi(token);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business management api client
     * @param token the token
     * @return the whatsapp business management api
     */
    public WhatsappBusinessManagementApi newBusinessManagementApi(String token) {
        return new WhatsappBusinessManagementApi(token);
    }

    /**
     * Creates a new synchronous/blocking Engagela api client
     * @param devKey the devKey
     * @param devSecret the devSecret
     * @return the whatsapp business cloud api
     */
    public WhatsappEngagelabApi newEngagelabApi(String devKey, String devSecret) {

        return new WhatsappEngagelabApi(Base64.getEncoder().encodeToString((devKey + ":" + devSecret).getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Creates a new synchronous/blocking Engagela BSP api client
     * @param devKey the devKey
     * @param devSecret the devSecret
     * @return the whatsapp business cloud api
     */
    public WhatsappEngagelabBspApi newEngagelabBspApi(String devKey, String devSecret) {

        return new WhatsappEngagelabBspApi(Base64.getEncoder().encodeToString((devKey + ":" + devSecret).getBytes(StandardCharsets.UTF_8)));
    }

}
