package havis.device.io;

public interface StateListener {

	/**
	 * Signals changes at the monitored entrance pin state.
	 * 
	 * @param e
	 *            The state event
	 */
	void stateChanged(StateEvent e);
}