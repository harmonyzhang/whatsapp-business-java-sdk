package com.whatsapp.api.service;


import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.organization.Apikeys;
import com.whatsapp.api.domain.organization.ApikeysResponse;
import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.webhook.engaglab.SetWebhook;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Engagelab（极光）bsp api 接口
 */
public interface WhatsappEngagelabBspApiService {


    /**
     * 创建组织.
     *
     * @param organization       the organization
     * @return the call
     */
    @POST("/" + WhatsappApiConfig.ENGAGELAB_DEV_API_VERSION + "/organization")
    Call<OrganizationResponse> createOrganization(@Body Organization organization);

    /**
     * 创建api密钥
     *
     * @param apikeys       the apikeys
     * @return the call
     */
    @POST("/whatsapp/" + WhatsappApiConfig.ENGAGELAB_DEV_API_VERSION + "/apikeys")
    Call<ApikeysResponse> createApikeys(@Body Apikeys apikeys);





}
