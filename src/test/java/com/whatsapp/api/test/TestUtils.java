package com.whatsapp.api.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatsapp.api.domain.templates.Component;
import com.whatsapp.api.domain.templates.response.Template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestUtils {


    /**
     * @return String with file contents
     */
    public String fromResource(String fileName) throws IOException, URISyntaxException {

        byte[] encoded = Files.readAllBytes(Paths.get(Objects.requireNonNull(this.getClass() //
                .getResource(fileName)).toURI()));
        return new String(encoded, StandardCharsets.UTF_8);


    }

    /**
     * @return byte[] with file contents
     */
    public byte[] bytesFromResource(String fileName) throws IOException, URISyntaxException {

        return Files.readAllBytes(Paths.get(Objects.requireNonNull(this.getClass() //
                .getResource(fileName)).toURI()));


    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true); //大小写脱敏 默认为false  需要改为true
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Template.class);

        String json = "[{\"id\":\"237657595397572\",\"name\":\"444\",\"language\":\"af\",\"category\":\"OTP\",\"status\":\"PENDING\",\"components\":[{\"type\":\"body\",\"text\":\"rrrrrrrrrrrr\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"quick_reply\",\"text\":\"rrrrr\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680503207},{\"id\":\"734844938117690\",\"name\":\"222\",\"language\":\"af\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"TEXT\",\"text\":\"999\"},{\"type\":\"BODY\",\"text\":\"南非荷兰语\"},{\"type\":\"FOOTER\",\"text\":\"页脚页脚页脚\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"1\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680312589},{\"id\":\"239025145239567\",\"name\":\"2222111111111\",\"language\":\"bn\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"text\",\"text\":\"2222\"},{\"type\":\"BODY\",\"text\":\"孟加拉语\"},{\"type\":\"FOOTER\",\"text\":\"2222\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"33333\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680312370},{\"id\":\"1452845685251899\",\"name\":\"ssssssssss\",\"language\":\"cs\",\"category\":\"MARKETING\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"TEXT\",\"text\":\"ffffff\"},{\"type\":\"BODY\",\"text\":\"捷克语\"},{\"type\":\"FOOTER\",\"text\":\"fffff\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"222\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680261732},{\"id\":\"940996787071679\",\"name\":\"9999\",\"language\":\"bn\",\"category\":\"MARKETING\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"BODY\",\"text\":\"孟加拉语\"},{\"type\":\"FOOTER\",\"text\":\"页脚\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680253756},{\"id\":\"779031673584818\",\"name\":\"quan\",\"language\":\"de\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"正文正文正文正文\"},{\"type\":\"footer\",\"text\":\"页脚页脚页脚页脚\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"phone_number\",\"text\":\"电话按钮\",\"phone_number\":\"15616201415\"},{\"type\":\"url\",\"text\":\"网站按钮\",\"url\":\"https://www.ssss.com\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680246431},{\"id\":\"890117248721706\",\"name\":\"quan\",\"language\":\"da\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"正文正文正文正文\uD83D\uDE0B{{1}}\",\"example\":{\"body_text\":[[\"变量1\"]]}},{\"type\":\"header\",\"format\":\"text\",\"text\":\"页眉\",\"example\":{\"header_text\":[\"页\"]}},{\"type\":\"footer\",\"text\":\"页脚页脚页脚\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"quick_reply\",\"text\":\"按钮1\"},{\"type\":\"quick_reply\",\"text\":\"按钮2\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680246429},{\"id\":\"737420414792314\",\"name\":\"12345678\",\"language\":\"af\",\"category\":\"OTP\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"text\",\"text\":\"页眉页眉页眉页眉\"},{\"type\":\"BODY\",\"text\":\"南非荷兰语正文正文正文正文\"},{\"type\":\"FOOTER\",\"text\":\"页脚页脚\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"1111\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680238273},{\"id\":\"1165970784109490\",\"name\":\"ceshi\",\"language\":\"az\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"text\",\"text\":\"sssssssssssssssss\"},{\"type\":\"BODY\",\"text\":\"亚塞拜然语\"},{\"type\":\"FOOTER\",\"text\":\"页脚页脚页脚\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"11\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680236883},{\"id\":\"751347656552653\",\"name\":\"test_004\",\"language\":\"az\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"1545\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680178022},{\"id\":\"104860235895773\",\"name\":\"nanfei\",\"language\":\"af\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"正文正文正文\uD83D\uDE17\"},{\"type\":\"header\",\"format\":\"text\",\"text\":\"页眉页眉页眉页眉\"},{\"type\":\"footer\",\"text\":\"页脚页脚页脚页脚\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"quick_reply\",\"text\":\"快速回复\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680174790},{\"id\":\"691675302733138\",\"name\":\"s\",\"language\":\"ar\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"text\",\"text\":\"页眉内容呀\"},{\"type\":\"BODY\",\"text\":\"阿拉伯语正文\uD83D\uDE1C\uD83D\uDC49\"},{\"type\":\"FOOTER\",\"text\":\"页脚页脚页脚\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"按钮1\"},{\"type\":\"QUICK_REPLY\",\"text\":\"按钮2\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680173405},{\"id\":\"178149647939521\",\"name\":\"hello_2\",\"language\":\"zh_CN\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"hello\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680172169},{\"id\":\"1228681764454378\",\"name\":\"tempname\",\"language\":\"en\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"正文\"},{\"type\":\"header\",\"format\":\"text\",\"text\":\"页眉页眉页眉页眉页眉\"},{\"type\":\"footer\",\"text\":\"页脚页脚页脚\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"quick_reply\",\"text\":\"按钮1\"},{\"type\":\"quick_reply\",\"text\":\"按钮2\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680155557},{\"id\":\"717792300137978\",\"name\":\"222\",\"language\":\"bn\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"正文正文正文正文正文正文正文正文正文正文正文正文{{1}}{{2}}\"},{\"type\":\"header\",\"format\":\"text\",\"text\":\"44444\"},{\"type\":\"footer\",\"text\":\"页脚 页脚 页脚 页脚 页脚 页脚 页脚 页脚 \"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"quick_reply\",\"text\":\"1111111111111111111111111\"},{\"type\":\"quick_reply\",\"text\":\"2222222222222222222222222\"},{\"type\":\"quick_reply\",\"text\":\"33333333333333333\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680135950},{\"id\":\"1228810264688385\",\"name\":\"eeeee\",\"language\":\"az\",\"category\":\"MARKETING\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"777\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680090766},{\"id\":\"1324991475064323\",\"name\":\"eeeee\",\"language\":\"af\",\"category\":\"MARKETING\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"eeee\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680090700},{\"id\":\"3405480893052323\",\"name\":\"hello_2\",\"language\":\"en\",\"category\":\"TRANSACTIONAL\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"hello {{1}}\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680089371},{\"id\":\"226951929900626\",\"name\":\"welcome_template3\",\"language\":\"en_US\",\"category\":\"TRANSACTIONAL\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"Hello {{1}}, welcome to our {{2}} test. \"},{\"type\":\"header\",\"format\":\"text\",\"text\":\"1448\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"phone_number\",\"text\":\"拨打电话\",\"phone_number\":\"15616201415\"},{\"type\":\"url\",\"text\":\"网站\",\"url\":\"https://www.baidu.com\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680089300},{\"id\":\"1530853524073491\",\"name\":\"namenamename\",\"language\":\"ca\",\"category\":\"TRANSACTIONAL\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"正文正文正文正文 图片\"},{\"type\":\"header\",\"format\":\"video\"},{\"type\":\"footer\",\"text\":\"页脚\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"phone_number\",\"text\":\"拨打电话\",\"phone_number\":\"15616201415\"},{\"type\":\"url\",\"text\":\"访问网站\",\"url\":\"https://www.baidu.com\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680078273},{\"id\":\"1402252007178541\",\"name\":\"rrr\",\"language\":\"az\",\"category\":\"OTP\",\"status\":\"REJECTED\",\"components\":[{\"type\":\"body\",\"text\":\"fffffffffffffffffffffffff正文正文正文{{1}}sssss{{2}}\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680077474},{\"id\":\"158823827070015\",\"name\":\"fff\",\"language\":\"bg\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"fff\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1680076764},{\"id\":\"720611186525501\",\"name\":\"dae\",\"language\":\"zh_CN\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"sssddffff\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679963213},{\"id\":\"766029091515819\",\"name\":\"dae\",\"language\":\"af\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"sss\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679963208},{\"id\":\"1704537666705871\",\"name\":\"3\",\"language\":\"zh_HK\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"dddddd\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679963132},{\"id\":\"1189043175140031\",\"name\":\"999998888\",\"language\":\"ar\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"55555555\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679962870},{\"id\":\"936269504220746\",\"name\":\"999998888\",\"language\":\"bg\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"999\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679962481},{\"id\":\"1285014009075955\",\"name\":\"223\",\"language\":\"bg\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"fff\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679907187},{\"id\":\"758922339184925\",\"name\":\"test_003\",\"language\":\"af\",\"category\":\"OTP\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"1530\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679761387},{\"id\":\"3482029015418043\",\"name\":\"test_002\",\"language\":\"zh_CN\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"1455\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679761387},{\"id\":\"596718172327896\",\"name\":\"ffff\",\"language\":\"az\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"99999\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679655976},{\"id\":\"543212167937369\",\"name\":\"test\",\"language\":\"ar\",\"category\":\"OTP\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"HEADER\",\"format\":\"TEXT\",\"text\":\"Wellcome title\"},{\"type\":\"BODY\",\"text\":\"Hello {{1}}, welcome to our {{2}} test. \",\"example\":{\"body_text\":[[\"Mr. José\",\"satisfaction\"]]}},{\"type\":\"FOOTER\",\"text\":\"Edit template\\\"\"},{\"type\":\"BUTTONS\",\"buttons\":[{\"type\":\"QUICK_REPLY\",\"text\":\"回复\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679625731},{\"id\":\"879921579719270\",\"name\":\"marketinguse\",\"language\":\"en\",\"category\":\"TRANSACTIONAL\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"Edit template\"},{\"type\":\"header\",\"format\":\"text\",\"text\":\"{{1}}\"},{\"type\":\"footer\",\"text\":\"Edit template\"},{\"type\":\"buttons\",\"buttons\":[{\"type\":\"url\",\"text\":\"网址\",\"url\":\"https://trade.tx.joinf.com/tms/system/index\"}]}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679477197},{\"id\":\"511920147809546\",\"name\":\"hello\",\"language\":\"en\",\"category\":\"MARKETING\",\"status\":\"APPROVED\",\"components\":[{\"type\":\"body\",\"text\":\"Hello, I am the service staff of Ningbo Zhongmao Network Technology Co., LTD. Please contact me if you have any needs\"}],\"quality_score\":\"UNKNOWN\",\"updated_time\":1679304199}]";
        List<Template> templates = mapper.readValue(json, javaType);
        System.out.println(templates);
    }

}
