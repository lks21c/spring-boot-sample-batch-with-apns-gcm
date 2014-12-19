package sample.apns.model;

import java.util.List;

import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;

/**
 * Apns Push Interface
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-19
 */
public interface ApnsPush {

	/**
	 * Send Badge
	 *
	 * @param badgeCount
	 * @param keystore
	 * @param password
	 * @param isProduction
	 * @param deviceTokenList
	 * @return ApnsPushNotifications
	 * @throws CommunicationException
	 * @throws KeystoreException
	 */
	public void badge(int badgeCount, String keystore, String password, boolean isProduction, List<String> deviceTokenList) throws  CommunicationException, KeystoreException;
}
