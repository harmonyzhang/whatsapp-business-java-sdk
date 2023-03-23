## :scroll: Get verification codes and verify then

You can:

- Get verification codes (by SMS or VOICE);
- Verify the verification codes

You need to verify the phone number you want to use to send messages to your customers. Phone numbers must be verified through SMS/voice call. The verification process can be done through this library.

See the examples:

#### [Get a verification code:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/test/java/com/whatsapp/api/examples/RequestVerificationCodeExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi(TestConstants.TOKEN);

var response = whatsappBusinessManagementApi.requestCode(TestConstants.PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US));

System.out.println(response);
```

---

#### [Verify a verification code:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/test/java/com/whatsapp/api/examples/RequestVerificationCodeExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi(TestConstants.TOKEN);

var response2 = whatsappBusinessManagementApi.verifyCode(TestConstants.PHONE_NUMBER_ID, new VerifyCode("0000"));

System.out.println(response2);
```
---

See full examples [here](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/test/java/com/whatsapp/api/examples/RequestVerificationCodeExample.java)

[:arrow_heading_up: back](../README.md#link-links)
