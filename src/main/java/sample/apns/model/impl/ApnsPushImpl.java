package sample.apns.model.impl;

import java.util.List;

import sample.apns.model.ApnsPush;
import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationPayload;

/**
 * Apns Push Implementation
 *
 * @author lks21c(lks21c@gmail.com)
 * @since 2014-12-19
 */
public class ApnsPushImpl implements ApnsPush {

	private static final String APNS_PRD_CERT_PATH = "PLEASE ENTER YOUR CERT PATH";

	private static final String APNS_PRD_PASSWORD = "PLEASE ENTER YOUR PASSWORD FOR YOUR CERT";

	private PushNotificationPayload payload = new PushNotificationPayload();

	@Override
	public void badge(int badgeCount, String keystore, String password, boolean isProduction, List<String> deviceTokenList) throws  CommunicationException, KeystoreException {
		Push.badge(badgeCount, keystore, password, isProduction, deviceTokenList);
	}
}
