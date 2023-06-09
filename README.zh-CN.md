# [ <img src="https://user-images.githubusercontent.com/7831956/222028018-181cf927-781c-40a9-af7a-e3c3d1e39390.png" width="28" height="28"> Whatsapp Business java api SDK](https://harmonyzhang.github.io/whatsapp-business-java-api/)

[![Java CI with Maven](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/maven-ci.yml)
[![CodeQL](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/codeql-analysis.yml)
[![](https://jitpack.io/v/harmonyzhang/whatsapp-business-java-sdk.svg)](https://jitpack.io/#harmonyzhang/whatsapp-business-java-sdk)
[![Javadoc](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/javadoc.yml/badge.svg)](https://github.com/harmonyzhang/whatsapp-business-java-sdk/actions/workflows/javadoc.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[English](./README.md) | **中文**

Whatsapp商业api SDK, 用java编写。这个SDK实现了官方 [Whatsapp Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) 和 [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api) 和 [极光 Whatsapp API](https://jiguang-docs.yuque.com/te6n14/whatsapp.engagelab/birhgucglgdgqc6c). 这些允许你:
- 管理您的WhatsApp商业帐户资产，如消息模板和电话号码;
- 发送消息给您的联系人，如简单的短信，消息与按钮，视频，图像，贴纸…
- 上传，删除和检索媒体文件。
- 接收webhook事件。

WhatsApp商业API允许中小型和大型企业与客户进行大规模沟通、群发。使用API，企业可以构建将成千上万的客户与代理或机器人连接起来的系统，从而实现编程和手动通信。此外，您可以将API与许多后端系统集成，例如CRM和营销平台。

官方新推出的Cloud API使得任何一家企业都能方便的申请到属于自己的商业Whatsapp账号。

此sdk实现whatsapp business cloud api 的v16.0版本、极光Whatsapp API 的v1版本。

:warning:该项目仍在建设中。欢迎投稿。

---
																     
## :link: 链接:

- [:hammer_and_wrench: Installation](#hammer_and_wrench-installation)
	- [Maven](#maven)
	- [Gradle](#gradle)
- [:eyes: Overview](#eyes-overview)
- [:scroll: Examples (Sending messages)](#scroll-examples-sending-messages)
	- [Sending a simple text message](#sending-a-simple-text-message)
	- [Sending a message with buttons (template)](#sending-a-message-with-buttons-template)
	- [Sending a message with a contact](#sending-a-message-with-a-contact)
	- [Sending an interactive message with buttons](#sending-an-interactive-message-with-buttons)
	- [Sending an interactive message with a list](#sending-an-interactive-message-with-a-list)
	- [Sending an audio message](#sending-an-audio-message)
	- [Sending a document message](#sending-a-document-message)
	- [Sending an image link message](#sending-an-image-link-message)
	- [Sending an image message](#sending-an-image-message)
	- [Sending a sticker message](#sending-a-sticker-message)
	- [Sending a video message](#sending-a-video-message)
- [:scroll: Examples (WhatsApp Business Management API)](#scroll-examples-whatsapp-business-management-api)
	- [Creating a message template](#create-a-message-template)
	- [Managing phone numbers](/docs/phone_numbers.md#scroll-managing-phone-numbers)
	- [Getting verification codes and verifying them.](docs/verification_codes.md#scroll-get-verification-codes-and-verify-then)
- [:arrow_down: WebHooks](#arrow_down-webhooks)
- [:paperclip: Media](#paperclip-media)
	- [Uploading media](#uploading-media)
	- [Retrieving the URL for a specific media](#retrieving-the-url-for-a-specific-media)
	- [Deleting media](#deleting-a-specific-media)
	- [downloading media](#downloading-media-from-a-media-url)
- [:open_file_folder: Examples folder](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/examples)


**See [javadoc](https://harmonyzhang.github.io/whatsapp-business-java-sdk/javadoc/)**

---


## :hammer_and_wrench: 安装

:warning: 这个库兼容 **java 1.8+**.

### Maven

**1. 添加 [JitPack](https://jitpack.io/#harmonyzhang/whatsapp-business-java-sdk) 存储库到您的构建文件:**

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

**2. 将以下Maven依赖项添加到项目中 `pom.xml`:**

```xml
<dependency>
  <groupId>com.github.harmonyzhang</groupId>
  <artifactId>whatsapp-business-java-sdk</artifactId>
  <version>v1.0.1</version>
</dependency> 
```

### Gradle:

**1. 将它添加到 build.gradle 仓库的末尾:**

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**2. 添加依赖项**

```gradle
dependencies {
	implementation 'com.github.harmonyzhang:whatsapp-business-java-sdk:v1.0.1'
}
```

**3. 将库安装到Maven的本地存储库中 `mvn install`**

或者，您可以克隆此存储库并运行 [示例](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/examples).

[:arrow_heading_up: back](#link-links)

---

## :eyes: Overview

There are two client classes that can be used to interact with the API:

1. [`WhatsappBusinessCloudApi`](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessCloudApi.java), a synchronous/blocking [WhatsApp Business Platform Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) client;
> Send and receive messages using a cloud-hosted version of the WhatsApp Business Platform. The Cloud API allows you to implement WhatsApp Business APIs without the cost of hosting of your own servers and also allows you to more easily scale your business messaging.


```java
 WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

 WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);
```

2. [`WhatsappBusinessManagementApi`](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessManagementApi.java), a synchronous/blocking [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api) client;
>The WhatsApp Business Management API allows you to programmatically manage your WhatsApp Business Account assets, such as message templates and phone numbers.

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TestConstants.TOKEN);
 ```

3. [`WhatsappEngagelabApi`](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappEngagelabApi.java), a synchronous/blocking [Engagelab Whatsapp API](https://jiguang-docs.yuque.com/te6n14/whatsapp.engagelab/birhgucglgdgqc6c) client;
>需要有个极光账号并开通whatsapp服务.

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappEngagelabApi whatsappEngagelabApi = factory.newEngagelabApi(TestConstants.ENGAGELAB_DEV_KEY,TestConstants.ENGAGELAB_DEV_SECRET);
 ```

These can be instantiated through the corresponding factory method of [`WhatsappApiFactory`](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/main/java/com/whatsapp/api/WhatsappApiFactory.java), by passing the token, which can be created following the instructions at [whatsapp](https://developers.facebook.com/docs/whatsapp/cloud-api/get-started).

[:arrow_heading_up: back](#link-links)

---

## :scroll: Examples (Sending messages)

#### [Sending a simple text message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendTextMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

Message message = MessageBuilder.builder()//
		.setTo(TestConstants.PHONE_NUMBER_1)//
		.buildTextMessage(new TextMessage()//
				.setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
				.setPreviewUrl(false));


whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179681-488341bf-a831-48ab-9ea1-312adcb769a4.png)

[:arrow_heading_up: back](#link-links)

---        
#### [Sending a message with buttons (template):](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendTemplateButtonMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

Message message = MessageBuilder.builder()//
	.setTo(TestConstants.PHONE_NUMBER_1)//
	.buildTemplateMessage(//
		new TemplateMessage()//
			.setLanguage(new Language(LanguageType.PT_BR))//
			.setName("schedule_confirmation3")//
			.addComponent(//
					new Component(ComponentType.BODY)//
						.addParameter(new TextParameter("Mauricio"))//
						.addParameter(new TextParameter("04/11/2022"))//
						.addParameter(new TextParameter("14:30")))//

	);

whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179613-3b9a30db-4f2f-4424-8073-adb8fce09226.png)

[:arrow_heading_up: back](#link-links)

---
#### [Sending a message with a contact](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendContactMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);
Message message = MessageBuilder.builder()//
	.setTo(TestConstants.PHONE_NUMBER_1)//
	.buildContactMessage(new ContactMessage()//
			.addContacts(new ContactsItem()//
					.addPhones(new PhonesItem()//
							.setPhone(TestConstants.PHONE_NUMBER_1)//
							.setType(AddressType.HOME))//
					.setName(new Name()//
							.setFormattedName("Mauricio Binda")//
							.setFirstName("Mauricio"))//
			));

whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179648-e4c97874-a380-49db-8337-39f17e661799.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending an interactive message with buttons:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendInteractiveMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

Message message = MessageBuilder.builder()//
	.setTo(TestConstants.PHONE_NUMBER_1)//
	.buildInteractiveMessage(InteractiveMessage.build() //
		.setAction(new Action() //
				.addButton(new Button() //
						.setType(ButtonType.REPLY)
						.setReply(new Reply() //
								.setId("UNIQUE_BUTTON_ID_1") //
								.setTitle("BUTTON_TITLE_1"))) //
				.addButton(new Button() //
						.setType(ButtonType.REPLY)
						.setReply(new Reply() //
								.setId("UNIQUE_BUTTON_ID_2") //
								.setTitle("BUTTON_TITLE_2")))
		) //
		.setType(InteractiveMessageType.BUTTON) //
		.setBody(new Body() //
				.setText("Body message")) //
	);

MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

System.out.println(messageResponse);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338759-b037cae5-6ed6-4b90-91c8-0541e7e19243.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending an interactive message with a list:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendInteractiveMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

Message message = MessageBuilder.builder()//
	.setTo(TestConstants.PHONE_NUMBER_1)//
	.buildInteractiveMessage(InteractiveMessage.build() //
		.setAction(new Action() //
			.setButtonText("BUTTON_TEXT") //
			.addSection(new Section() //
					.setTitle("Title 1") //
					.addRow(new Row() //
							.setId("SECTION_1_ROW_1_ID") //
							.setTitle("Title 1") //
							.setDescription("SECTION_1_ROW_1_DESCRIPTION")) //
					.addRow(new Row() //
							.setId("SECTION_1_ROW_2_ID") //
							.setTitle("Title 2") //
							.setDescription("SECTION_1_ROW_2_DESCRIPTION")) //
					.addRow(new Row() //
							.setId("SECTION_1_ROW_3_ID") //
							.setTitle("Title 3") //
							.setDescription("SECTION_1_ROW_3_DESCRIPTION")) //
			) //
			.addSection(new Section() //
					.setTitle("Title 2") //
					.addRow(new Row() //
							.setId("SECTION_2_ROW_1_ID") //
							.setTitle("Title 1") //
							.setDescription("SECTION_2_ROW_1_DESCRIPTION")) //
					.addRow(new Row() //
							.setId("SECTION_2_ROW_2_ID") //
							.setTitle("Title 2") //
							.setDescription("SECTION_2_ROW_2_DESCRIPTION")) //
					.addRow(new Row() //
							.setId("SECTION_2_ROW_3_ID") //
							.setTitle("Title 3") //
							.setDescription("SECTION_2_ROW_3_DESCRIPTION")) //
			)
		) //
		.setType(InteractiveMessageType.LIST) //
		.setHeader(new Header() //
				.setType(HeaderType.TEXT) //
				.setText("Header Text")) //
		.setBody(new Body() //
				.setText("Body message")) //
		.setFooter(new Footer() //
				.setText("Footer Text")) //
	);

MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

System.out.println(messageResponse);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338815-81ece610-225f-485e-a9f5-bf3d034a5b2a.png)

![image](https://user-images.githubusercontent.com/7831956/221338845-a2e19ba7-c6d5-4247-96e2-e0df163b89f2.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending an audio message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendAudioMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var audioMessage = new AudioMessage()//
.setId("6418001414900549");

Message message = MessageBuilder.builder()//
.setTo(TestConstants.PHONE_NUMBER_1)//
.buildAudioMessage(audioMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338759-b037cae5-6ed6-4b90-91c8-0541e7e19243.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending a document message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendDocumentMessageExample.java)

```java

WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var documentMessage = new DocumentMessage()//
.setId("1238834210396519")// media id (uploaded before)
.setCaption("Media Object details from developers.facebook.com")//
.setFileName("Media oject.pdf");

Message message = MessageBuilder.builder()//
.setTo(TestConstants.PHONE_NUMBER_1)//
.buildDocumentMessage(documentMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222820774-489b54fa-4975-4688-927a-09157fb54777.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending an image link message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendImageLinkMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var imageMessage = new ImageMessage()//
.setLink("https://upload.wikimedia.org/wikipedia/pt/4/45/Yoda.jpg").setCaption("See this image, please");

Message message = MessageBuilder.builder()//
.setTo(TestConstants.PHONE_NUMBER_1)//
.buildImageMessage(imageMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

```
![image](https://user-images.githubusercontent.com/7831956/222820971-f27cdb60-9b93-4a8f-96c3-0740bbada95b.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending an image message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendImageMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var imageMessage = new ImageMessage()//
.setId("186057067456357")// media id (uploaded before)
.setCaption("See this image, please");

Message message = MessageBuilder.builder()//
.setTo(TestConstants.PHONE_NUMBER_1)//
.buildImageMessage(imageMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);

```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222820870-3913c340-2f61-4622-bddc-c0863ec03e7d.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending a sticker message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendStickerExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var stickerMessage = new StickerMessage()//
		.setId("527984052814860");// media id (uploaded before)


Message message = MessageBuilder.builder()//
		.setTo(TestConstants.PHONE_NUMBER_1)//
		.buildStickerMessage(stickerMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222821074-a7f0d1c4-e68e-4350-b108-7c97bccf17bb.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending a video message:](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/SendVideoStickerExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var videoMessage = new VideoMessage()//
.setId("1236364143659727")// media id (uploaded before)
.setCaption("See this video");


Message message = MessageBuilder.builder()//
.setTo(TestConstants.PHONE_NUMBER_1)//
.buildVideoMessage(videoMessage);


MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(TestConstants.PHONE_NUMBER_ID, message);
```

[:arrow_heading_up: back](#link-links)

---

## :scroll: Examples (WhatsApp Business Management API)

#### [Create a message template](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/CreateMessageTemplate3Example.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(TestConstants.TOKEN);

var template = new MessageTemplate();

template.setName("schedule_confirmation3")//
	.setCategory(Category.TRANSACTIONAL)//
	.setLanguage(Language.PT_BR)//
	.addComponent(new HeaderComponent()//
			.setText("Confirmação de Atendimento")//
			.setFormat(HeaderFormat.TEXT))//
	.addComponent(new BodyComponent()//
			.setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
			.setExample(new Example()//
					.addBodyTextExamples("Maria", "04/11/2022", "13:30")//
			))//
	.addComponent(new ButtonComponent()//
			.addButton(new QuickReplyButton("SIM"))//
			.addButton(new QuickReplyButton("NÃO"))//
			.addButton(new QuickReplyButton("REMARCAR")//
			)


	)//
	.addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


;

var response = whatsappBusinessCloudApi.createMessageTemplate(TestConstants.WABA_ID, template);

```

---

### :heavy_plus_sign: [See more examples here](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/examples).

[:arrow_heading_up: back](#link-links)

---

## :arrow_down: WebHooks
Webhooks are triggered when a customer performs an action or the status for a message a business sends a customer changes.

WebHook objects are mapped on [**WebHookEvent class**](https://github.com/harmonyzhang/whatsapp-business-java-sdk/blob/main/src/main/java/com/whatsapp/api/domain/webhook/WebHookEvent.java)

See [Whatsapp api documentation](https://developers.facebook.com/docs/whatsapp/cloud-api/webhooks) for more details.
**Example:**

```java
//payload = the webhook payload json sent by Whatsapp
//using WebHook.constructEvent() to deserialize event
WebHookEvent event = WebHook.constructEvent(payload);
```
See an example [here](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/examples/WebHookExample.java)

You get a webhooks notification:

1- When a customer performs an action

- Sends a text message to the business
- Sends an image, video, audio, document, or sticker to the business
- Sends contact information to the business
- Sends location information to the business
- Clicks a reply button set up by the business
- Clicks a call-to-actions button on an Ad that Clicks to WhatsApp
- Clicks an item on a business' list
- Updates their profile information such as their phone number
- Asks for information about a specific product
- Orders products being sold by the business

2- When the status for a message received by a business changes (includes pricing information)

- delivered
- read
- sent

3- When WhatsApp Business Management API updates:

- Message Template Updates
- Phone Number Updates
- WABA Updates

[:arrow_heading_up: back](#link-links)

---

## :paperclip: Media

You can use 4 different endpoints to manage your media:

- Upload media.
- Retrieve the URL for a specific media.
- Delete a specific media.
- Download media from a media URL.

**See the examples:**

#### [Uploading media](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/UploadMediaExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);


var fileName = "starwars.png";

byte[] fileContent = Files.readAllBytes(Paths.get("src/test/resources/" + fileName));


var response = whatsappBusinessCloudApi.uploadMedia(TestConstants.PHONE_NUMBER_ID, fileName, FileType.PNG, fileContent);

System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Retrieving the URL for a specific media](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/RetrieveMediaUrlExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

var response = whatsappBusinessCloudApi.retrieveMediaUrl("1227829768162607");

System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Deleting a specific media](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/DeleteMediaExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

//delete media
var response = whatsappBusinessCloudApi.deleteMedia("723050006231302");

System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Downloading media from a media URL](https://github.com/harmonyzhang/whatsapp-business-java-sdk/tree/main/src/test/java/com/whatsapp/api/test/examples/DownloadMediaExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance();

WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(TestConstants.TOKEN);

// retrieve the media file url
var mediaUrl = whatsappBusinessCloudApi.retrieveMediaUrl("723050006231302");

//call downloadMediaFile() -> return a MediaFile object with the file name and content (byte[])
var mediaFile = whatsappBusinessCloudApi.downloadMediaFile(mediaUrl.url());

//write the file in the folder "/examples/"
Files.write(Path.of("src/test/java/com/whatsapp/api/examples/" + mediaFile.fileName()), mediaFile.content());
```
[:arrow_heading_up: back](#link-links)

### Reference source

[whatsapp-business-java-api](https://github.com/Bindambc/whatsapp-business-java-api)

