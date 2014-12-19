package sample.gcm.vo;

import java.util.List;

import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;

/**
 * GcmMulticatResult <br /> <br />
 *
 * Wrapper class of {@link MulticastResult} <br />
 *
 * The purpose of this class is to remove dependency of gcm-server.jar in case of changing open source library for GCM.
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-18
 */
public final class GcmMulticatResult {

	/**
	 * success count
	 */
	private int success;

	/**
	 * failure count
	 */
	private int failure;

	/**
	 * canonicalIds count which means the count of  canonicalIds that Google suggests us to use. <br /><br />
	 * @see <a href="https://developer.android.com/google/gcm/adv.html#canonical">https://developer.android.com/google/gcm/adv.html#canonical</a>
	 */
	private int canonicalIds;

	/**
	 * unique multicast Id <br />
	 * @see <a href="https://developer.android.com/google/gcm/http.html#response">https://developer.android.com/google/gcm/http.html#response</a>
	 */
	private long multicastId;


	/**
	 * Result List containing {@link Result}.
	 *
	 */
	private List<Result> results;

	/**
	 * retryMulticastIds
	 */
	private List<Long> retryMulticastIds;

	public GcmMulticatResult() {
	}

	public GcmMulticatResult(MulticastResult multicastResult) {
		this.success = multicastResult.getSuccess();
		this.failure = multicastResult.getFailure();
		this.canonicalIds = multicastResult.getCanonicalIds();
		this.multicastId = multicastResult.getMulticastId();
		this.results = multicastResult.getResults();
		this.retryMulticastIds = multicastResult.getRetryMulticastIds();
	}

	/**
	 * @return success {@link #success Read This}
	 */
	public int getSuccess() {
		return success;
	}

	/**
	 * @param success {@link #success Read This}
	 */
	public void setSuccess(int success) {
		this.success = success;
	}

	/**
	 * @return failure {@link #failure Read This}
	 */
	public int getFailure() {
		return failure;
	}

	/**
	 * @param failure {@link #failure Read This}
	 */
	public void setFailure(int failure) {
		this.failure = failure;
	}

	/**
	 * @return canonicalIds {@link #canonicalIds Read This}
	 */
	public int getCanonicalIds() {
		return canonicalIds;
	}

	/**
	 * @param canonicalIds {@link #canonicalIds Read This}
	 */
	public void setCanonicalIds(int canonicalIds) {
		this.canonicalIds = canonicalIds;
	}

	/**
	 * @return multicastId {@link #multicastId Read This}
	 */
	public long getMulticastId() {
		return multicastId;
	}

	/**
	 * @param multicastId {@link #multicastId Read This}
	 */
	public void setMulticastId(long multicastId) {
		this.multicastId = multicastId;
	}

	/**
	 * @param results {@link #results Read This}
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * @param results {@link #results Read This}
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

	/**
	 * @return retryMulticastIds {@link #retryMulticastIds Read This}
	 */
	public List<Long> getRetryMulticastIds() {
		return retryMulticastIds;
	}

	/**
	 * @param retryMulticastIds {@link #retryMulticastIds Read This}
	 */
	public void setRetryMulticastIds(List<Long> retryMulticastIds) {
		this.retryMulticastIds = retryMulticastIds;
	}

	@Override
	  public String toString() {
	    StringBuilder builder = new StringBuilder("GcmMulticastResult(")
	        .append("multicast_id=").append(multicastId).append(",")
	        .append("total=").append(success + failure).append(",")
	        .append("success=").append(success).append(",")
	        .append("failure=").append(failure).append(",")
	        .append("canonical_ids=").append(canonicalIds).append(",");
	    if (!results.isEmpty()) {
	      builder.append("results: " + results);
	    }
	    return builder.toString();
	  }
}
