package andrealeet;

import net.fabricmc.api.ClientModInitializer;

public class ProtocolTestClient implements ClientModInitializer {
	private static boolean initialized = false;
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		if(initialized) throw new RuntimeException("Already initialized");
		ProtocolTestMod.INSTANCE.initialize();
		initialized = true;
	}
}