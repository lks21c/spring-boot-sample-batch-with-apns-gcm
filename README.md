spring-boot-gcm-server
======================
**This is a sample application which has a simple Gcm Spring bean using gcm-server.jar on top of spring-boot-sample-batch.**

## Background
In my company, I had a chance to make an internal "Push Server"
which is a gateway to APNS and GCM.

I searched for open source about GCM and found gcm-server library.
Instead of using gcm-server.jar directly in the system,
I made a spring bean which is a wrapping of gcm-server library.

## Dependency
* spring-boot-sample-batch : I chose this project as a base project since
I think many of you consider Push System as a batch system.
* gcm-server.jar : I reviewed the library and I thought this is a major library among GCM libraries and looked stable.

## Sample Code
```java
@Resource
GcmPush push;

@Test
public void testSendPush() throws Exception {
  String REGISTRATION_ID = "SAMPLE REG ID";
  String content = "This is Gcm Test.";
  String data = "{\"val\":\"\",\"content\":\"" + content  + "}";

  GcmPushInfo info = new GcmPushInfo();
  info.setData(data);
  regIdList.add(REGISTRATION_ID);
  info.setRegIdList(regIdList);
  GcmMulticatResult result = push.sendPush(info);
}
```
