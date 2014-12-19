package sample.gcm.model;

import java.io.IOException;

import com.google.android.gcm.server.InvalidRequestException;

import sample.gcm.exception.GcmMulticastLimitExceededException;
import sample.gcm.vo.GcmMulticatResult;
import sample.gcm.vo.GcmPushInfo;

/**
 * Gcm Push Interface
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-16
 */
public interface GcmPush {
	/**
	 * Push를 보낸다.
	 *
	 * @param {@link GcmPushInfo}
	 * @return {@link GcmMulticatResult}
	 * @throws GcmMulticastLimitExceededException
	 * @throws IllegalArgumentException
	 * @throws InvalidRequestException
	 * @throws IOException
	 */
	public GcmMulticatResult sendPush(GcmPushInfo info) throws GcmMulticastLimitExceededException, IllegalArgumentException, InvalidRequestException, IOException;
}
