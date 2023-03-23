package com.whatsapp.api.configuration;

/**
 * The type Whatsapp api config.
 */
public class WhatsappApiConfig {

    /**
     * The constant API_VERSION.
     */
    public final static String API_VERSION = "v16.0";

    /**
     * The constant BASE_DOMAIN.
     */
    public static String BASE_DOMAIN = "https://graph.facebook.com/";

    /**
     * The constant 极光 API_VERSION.
     */
    public final static String ENGAGELAB_API_VERSION = "v1";

    /**
     * The constant 极光 DOMAIN.
     */
    public static String ENGAGELAB_DOMAIN = "https://wa.api.engagelab.cc/";

    /**
     * Sets base domain.
     *
     * @param baseDomain the base domain
     */
    public static void setBaseDomain(String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }

    public static void setEngagelabDomain(String engagelabDomain) {
        ENGAGELAB_DOMAIN = engagelabDomain;
    }


}
