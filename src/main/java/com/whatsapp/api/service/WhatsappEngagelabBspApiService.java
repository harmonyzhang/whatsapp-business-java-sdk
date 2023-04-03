package com.whatsapp.api.service;


import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
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


}
