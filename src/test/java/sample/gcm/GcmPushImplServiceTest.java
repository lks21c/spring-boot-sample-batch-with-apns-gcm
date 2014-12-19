package sample.gcm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sample.gcm.exception.GcmMulticastLimitExceededException;
import sample.gcm.model.GcmPush;
import sample.gcm.model.impl.GcmPushImpl;
import sample.gcm.vo.GcmMulticatResult;
import sample.gcm.vo.GcmPushInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GcmPushImplServiceTest.TestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class GcmPushImplServiceTest {

	@Resource
	GcmPush push;

	private static final String NO_CANONICAL_REG_ID_1 = "PLEASE ENTER NO_CANONICAL_REG_ID_1";

	private static final String CANONICAL_REG_ID_1 = "PLEASE ENTER CANONICAL_REG_ID_1";

	private static final String CANONICAL_REG_ID_2 = "PLEASE ENTER CANONICAL_REG_ID_2";

	private String data;

	private List<String> regIdList = new ArrayList<String>();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		String content = "This is Gcm Test. " + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds;
		data = "{\"val\":\"\",\"content\":\"" + content  + "}";
	}

	@Test
	public void PUSH_TEST_1_PEOPLE_WITH_NO_CANONICAL_REG_ID() throws Exception {
		GcmPushInfo info = new GcmPushInfo();
		info.setData(data);
		regIdList.add(NO_CANONICAL_REG_ID_1);
		info.setRegIdList(regIdList);
		GcmMulticatResult result = push.sendPush(info);

		Assert.assertNotNull(result.getMulticastId());
		Assert.assertEquals(0, result.getFailure());
		Assert.assertEquals(regIdList.size(), result.getSuccess());
		System.out.println(result.toString());
	}

	@Test
	public void PUSH_TEST_1_PEOPLE_WITH_CANONICAL_REG_ID() throws Exception {
		GcmPushInfo info = new GcmPushInfo();
		info.setData(data);
		regIdList.add(CANONICAL_REG_ID_1);
		info.setRegIdList(regIdList);
		GcmMulticatResult result = push.sendPush(info);

		Assert.assertNotNull(result.getMulticastId());
		Assert.assertEquals(0, result.getFailure());
		Assert.assertEquals(regIdList.size(), result.getSuccess());
		System.out.println(result.toString());
	}

	@Test
	public void PUSH_TEST_2_PEOPLE() throws Exception {
		GcmPushInfo info = new GcmPushInfo();
		info.setData(data);
		regIdList.add(CANONICAL_REG_ID_1);
		regIdList.add(CANONICAL_REG_ID_2);
		info.setRegIdList(regIdList);
		GcmMulticatResult result = push.sendPush(info);

		Assert.assertNotNull(result.getMulticastId());
		Assert.assertEquals(0, result.getFailure());
		Assert.assertEquals(regIdList.size(), result.getSuccess());
		System.out.println(result.toString());
	}

	@Test
	public void PUSH_TEST_info_null() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("info should not be null.");
		push.sendPush(null);
	}

	@Test
	public void PUSH_TEST_data_null() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("data should not be Null or empty string.");

		GcmPushInfo info = new GcmPushInfo();
		info.setData(null);
		regIdList.add(NO_CANONICAL_REG_ID_1 + 1);
		info.setRegIdList(regIdList);
		push.sendPush(info);
	}

	@Test
	public void PUSH_TEST_regList_null() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("regIdList should not be Null or empty string.");

		GcmPushInfo info = new GcmPushInfo();
		info.setData(data);
		info.setRegIdList(null);
		push.sendPush(info);
	}

	@Test
	public void PUSH_TEST_1001_REG_ID() throws Exception {
		this.thrown.expect(GcmMulticastLimitExceededException.class);
		for (int i = 0; i < 1001; i++) {
			regIdList.add(NO_CANONICAL_REG_ID_1);
		}
		GcmPushInfo info = new GcmPushInfo();
		info.setData(data);
		info.setRegIdList(regIdList);
		push.sendPush(info);
	}

	@Configuration
	static class TestConfig {

		@Bean
		public GcmPush gcmPush() {
			GcmPushImpl pushImpl = new GcmPushImpl();
			return pushImpl;
		}
	}
}
