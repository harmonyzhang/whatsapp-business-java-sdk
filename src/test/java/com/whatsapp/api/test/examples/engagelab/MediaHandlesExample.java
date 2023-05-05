package com.whatsapp.api.test.examples.engagelab;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.response.MediaHandlesResponse;
import com.whatsapp.api.impl.WhatsappEngagelabApi;
import com.whatsapp.api.test.TestConstants;

import java.io.File;

/**
 * @Classname MediaHandlesExample
 * @Description TODO
 */
public class MediaHandlesExample {
    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);
        File file = new File("/Users/guomingwei/Downloads/宝箱bbbb.png");
        MediaHandlesResponse mediaHandlesResponse = whatsappEngagelabApi.mediaHandles(file);
        System.out.println(mediaHandlesResponse);

    }
}
