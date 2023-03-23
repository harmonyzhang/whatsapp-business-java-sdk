package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.MediaFile;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadMediaExample {

    public static void main(String[] args) throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

        // retrieve the media file url
        Media mediaUrl = whatsappBusinessCloudApi.retrieveMediaUrl("723050006231302");

        //call downloadMediaFile() -> return a MediaFile object with the file name and content (byte[])
        MediaFile mediaFile = whatsappBusinessCloudApi.downloadMediaFile(mediaUrl.getUrl());

        //write the file in the folder "/examples/"
        Files.write(Paths.get("src/test/java/com/whatsapp/api/examples/" + mediaFile.getFileName()), mediaFile.getContent());

    }


}
