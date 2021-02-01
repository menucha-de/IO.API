package havis.device.io;

/**
 * Implements a Callback interface for LLRP Services of the IO consumer.
 */
public interface IOConsumer extends StateListener {

	/**
	 * Signals the connection attempts of a different client.
	 */
	void connectionAttempted();

	/**
	 * Signals an upcoming keepAlive event.
	 */
	void keepAlive();
}