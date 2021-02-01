package havis.device.io;

public interface IODeviceFactory {

	IODevice getInstance();

	void release(IODevice instance);
}