package sample.apns;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sample.apns.model.ApnsPush;
import sample.apns.model.impl.ApnsPushImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApnsPushImplServiceTest.TestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ApnsPushImplServiceTest {

	private static final String SAMPLE_DEVICE_TOKEN = "PLEASE ENTER A SAMPLE DEVICE TOKEN";

	private List<String> deviceTokenList = new ArrayList<String>();

	@Resource
	private ApnsPush apnsPush;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void testPushBadge() throws Exception {
        deviceTokenList.add(SAMPLE_DEVICE_TOKEN);
        apnsPush.badge(10, "KEYSTORE PATH", "PASSWORD", false, deviceTokenList);
	}

	@Configuration
	static class TestConfig {

		@Bean
		public ApnsPush apnsPush() {
			ApnsPushImpl pushImpl = new ApnsPushImpl();
			return pushImpl;
		}
	}
}
