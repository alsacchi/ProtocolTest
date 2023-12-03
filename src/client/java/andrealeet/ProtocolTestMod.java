package andrealeet;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;

public enum ProtocolTestMod {
    INSTANCE;

    public static final MinecraftClient MC = MinecraftClient.getInstance();
    public static final ClientPlayerInteractionManager CPIM = MC.interactionManager;

    public void initialize() {}


}
