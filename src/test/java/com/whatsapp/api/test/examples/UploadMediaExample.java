package com.whatsapp.api.test.examples;

import com.whatsapp.api.test.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadMediaExample {

    public static void main(String[] args) throws IOException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);


        String fileName = "starwars.png";

        byte[] fileContent = Files.readAllBytes(Paths.get("src/test/resources/" + fileName));


        UploadResponse response = whatsappBusinessCloudApi.uploadMedia(TestConstants.PHONE_NUMBER_ID, fileName, FileType.PNG, fileContent);

        System.out.println(response);
    }


}
