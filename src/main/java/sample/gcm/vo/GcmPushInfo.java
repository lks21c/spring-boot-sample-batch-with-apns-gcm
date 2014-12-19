package sample.gcm.vo;

import java.util.List;

/**
 * GcmPushInfo <br /> <br />
 *
 * Request info class in order to send to Google Server.<br />
 * Simple you can use only {@link #data data} and {@link #regIdList regIdList}.
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-16
 */
public class GcmPushInfo {

	/**
	 * This parameter specifies a JSON object whose fields represents the key-value pairs of the message's payload data.
	 * @see https://developer.android.com/google/gcm/server.html#send-msg
	 */
	private String data;

	/**
	 * This parameter specifies a string array containing the list of devices (registration IDs) receiving the message.<br />
	 *  It must contain at least 1 and at most 1000 registration IDs. To send a multicast message, you must use JSON.
	 * @see https://developer.android.com/google/gcm/server.html#send-msg
	 */
	private List<String> regIdList;

	/**
	 * This parameter indicates that the message should not be sent immediately if the device is idle.
	 * Default value is as false for low latency.
	 * @see https://developer.android.com/google/gcm/server.html#send-msg
	 */
	private boolean delayWhileIdle = false;

	/**
	 * TTL for the push in case of offline devices.
	 * Default value is as false for low latency.
	 * @see https://developer.android.com/google/gcm/server.html#send-msg
	 */
	private int timeToLive = 2419200;

	/**
	 * @see https://developer.android.com/google/gcm/server.html#send-msg
	 */
	private String collapseKey;

	/**
	 * @return data {@link #data Read This}
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data {@link #data Read This}
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return regIdList {@link #regIdList Read This}
	 */
	public List<String> getRegIdList() {
		return regIdList;
	}

	/**
	 * @param regIdList {@link #regIdList Read This}
	 */
	public void setRegIdList(List<String> regIdList) {
		this.regIdList = regIdList;
	}

	/**
	 * @return delayWhileIdle {@link #delayWhileIdle Read This}
	 */
	public boolean isDelayWhileIdle() {
		return delayWhileIdle;
	}

	/**
	 * @param delayWhileIdle {@link #delayWhileIdle Read This}
	 */
	public void setDelayWhileIdle(boolean delayWhileIdle) {
		this.delayWhileIdle = delayWhileIdle;
	}

	/**
	 * @return timeToLive {@link #timeToLive Read This}
	 */
	public int getTimeToLive() {
		return timeToLive;
	}

	/**
	 * @param timeToLive {@link #timeToLive Read This}
	 */
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	/**
	 * @return collapseKey {@link #collapseKey Read This}
	 */
	public String getCollapseKey() {
		return collapseKey;
	}

	/**
	 * @param collapseKey {@link #collapseKey Read This}
	 */
	public void setCollapseKey(String collapseKey) {
		this.collapseKey = collapseKey;
	}
}