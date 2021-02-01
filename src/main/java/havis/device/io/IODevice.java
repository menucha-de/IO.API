package havis.device.io;

import havis.device.io.exception.ConnectionException;
import havis.device.io.exception.ImplementationException;
import havis.device.io.exception.ParameterException;

import java.util.List;

/**
 * Common definition of a IOController
 */
public interface IODevice {

	/**
	 * Tries to get the exclusive access to the IO-Controller and register
	 * consumer as current owner of the access.
	 * 
	 * @param consumer
	 * @param timeout
	 *            Specifies an time in milliseconds in which the consumer
	 *            answers on a request.
	 * @throws ConnectionException
	 *             If a process already received the access and does not release
	 *             the consumer
	 */
	void openConnection(IOConsumer consumer, int timeout)
			throws ConnectionException, ImplementationException;

	/**
	 * Closes the access to the IOController
	 */
	void closeConnection() throws ConnectionException, ImplementationException;

	/**
	 * Gets the actual configuration of the controller in a list depending on
	 * the type and pin. Returns configuration of all input/output pins if
	 * configuration type is {@link Type#ALL} or {@link Type#IO} pin is zero.
	 * 
	 * @param type
	 *            The configuration type
	 * @param pin
	 *            The pin id
	 * @return The actual configuration of the controller in a list depending on
	 *         the type pin.
	 * @throws ParameterException
	 *             If pin is lower than zero or pin greater count of available
	 *             pins
	 */
	List<Configuration> getConfiguration(Type type, short pin)
			throws ConnectionException, ParameterException,
			ImplementationException;

	/**
	 * Set the configuration to the values given in the list configuration. Only
	 * the given configurations will be set.
	 * 
	 * @param configuration
	 * @throws ParameterException
	 *             If an given value is invalid.
	 */
	void setConfiguration(List<Configuration> configuration)
			throws ConnectionException, ParameterException,
			ImplementationException;

	/**
	 * Reset the whole configuration of the controller to factory default
	 */
	void resetConfiguration() throws ImplementationException,
			ConnectionException, ImplementationException;
}
