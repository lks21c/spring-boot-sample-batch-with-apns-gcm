package sample.gcm.model.impl;

import java.io.IOException;

import org.springframework.util.Assert;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

import sample.gcm.exception.GcmMulticastLimitExceededException;
import sample.gcm.model.GcmPush;
import sample.gcm.vo.GcmMulticatResult;
import sample.gcm.vo.GcmPushInfo;

/**
 * Gcm Push Implementation.
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-16
 */
public class GcmPushImpl implements GcmPush {

	private String GCM_API_KEY = "PLEASE ENTER YOUR OWN GCM API KEY.";

	private static final int GCM_MULTICAST_LIMIT = 1000;

	private Sender sender = new Sender(GCM_API_KEY);

	@Override
	public GcmMulticatResult sendPush(GcmPushInfo info) throws GcmMulticastLimitExceededException, IllegalArgumentException, InvalidRequestException, IOException {
		// Validation
		Assert.notNull(info, "info should not be null.");
		Assert.isTrue(info.getData() != null && info.getData().length() > 0, "data should not be Null or empty string.");
		Assert.isTrue(info.getRegIdList() != null && info.getRegIdList().size() > 0, "regIdList should not be Null or empty string.");
		if (info.getRegIdList().size() > GCM_MULTICAST_LIMIT) {
			throw new GcmMulticastLimitExceededException();
		}

		Message message = new Message.Builder()
				.addData("message", info.getData())
				.delayWhileIdle(info.isDelayWhileIdle())
				.timeToLive(info.getTimeToLive())
				.collapseKey(info.getCollapseKey())
				.build();
		MulticastResult result = sender.sendNoRetry(message, info.getRegIdList());
		GcmMulticatResult gcmMulticatResult = new GcmMulticatResult(result);
		return gcmMulticatResult;
	}
}
