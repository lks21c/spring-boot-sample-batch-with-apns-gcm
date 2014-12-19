spring-boot-sample-batch-with-apns-gcm
======================
This is a sample application for APNS and GCM on top of spring-boot-sample-batch

## Background
In my company, I had a chance to make an internal "Push Server"
which is a gateway server to APNS and GCM.

So I decided to use [Javapns](https://code.google.com/p/javapns/) and [Gcm-Server](https://code.google.com/p/gcm/) which are one of the most popular libraries in Java.

I made spring wrapping beans of Javapns and Gcm-Server.
I also used spring-boot-sample-batch since it could be the most feasible use case for developers.

## Dependency
* [spring-boot-sample-batch](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-batch) : I chose this project as a base project since
I think many of you consider Push System as a batch system.
* [Javapns](https://code.google.com/p/javapns/)
* [Gcm-Server](https://code.google.com/p/gcm/)

## Sample Code
```java
@Resource
GcmPush gcmPush;

@Test
public void testSendPush() throws Exception {
  String REGISTRATION_ID = "SAMPLE REG ID";
  String content = "This is Gcm Test.";
  String data = "{\"val\":\"\",\"content\":\"" + content  + "}";

  GcmPushInfo info = new GcmPushInfo();
  info.setData(data);
  regIdList.add(REGISTRATION_ID);
  info.setRegIdList(regIdList);
  GcmMulticatResult result = gcmPush.sendPush(info);
}

@Resource
ApnsPush apnsPush;

@Test
public void testPushBadge() throws Exception {
  String SAMPLE_DEVICE_TOKEN = "PLEASE ENTER A SAMPLE DEVICE TOKEN";
  List<String> deviceTokenList = new ArrayList<String>();
  deviceTokenList.add(SAMPLE_DEVICE_TOKEN);
  apnsPush.badge(10, "KEYSTORE PATH", "PASSWORD", false, deviceTokenList);
}
```
