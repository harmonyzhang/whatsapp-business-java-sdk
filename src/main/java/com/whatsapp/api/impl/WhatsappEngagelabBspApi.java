package com.whatsapp.api.impl;

import com.whatsapp.api.domain.organization.Organization;
import com.whatsapp.api.domain.organization.OrganizationResponse;
import com.whatsapp.api.service.WhatsappEngagelabBspApiService;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createServiceBasic;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;
import static com.whatsapp.api.configuration.WhatsappApiConfig.ENGAGELAB_DEV_DOMAIN;

/**
 * 极光 BSP API的同步/阻塞实现
 * method calls.
 *
 * @see <a href="https://jiguang-docs.yuque.com/te6n14/whatsapp.engagelab/birhgucglgdgqc6c">Engagelab WhatsApp API</a>
 */
public class WhatsappEngagelabBspApi {

    private final WhatsappEngagelabBspApiService whatsappEngagelabBspApiService;


    /**
     * 实例化一个新的极光 bsp api.
     *
     * @param token the token
     */
    public WhatsappEngagelabBspApi(String token) {
        this.whatsappEngagelabBspApiService = createServiceBasic(WhatsappEngagelabBspApiService.class, token, ENGAGELAB_DEV_DOMAIN);

    }

    /**
     * 创建组织
     * @param organization       The {@link Organization} object.
     * @return {@link OrganizationResponse}
     */
    public OrganizationResponse createOrganization(Organization organization) {
        return executeSync(whatsappEngagelabBspApiService.createOrganization(organization));
    }



}
