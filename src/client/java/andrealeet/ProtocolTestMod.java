package andrealeet;

import andrealeet.listener.Event;
import andrealeet.listener.EventManager;
import andrealeet.mods.ChatParser;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;

public enum ProtocolTestMod {
    INSTANCE;
    int iter = 0;
    public static final MinecraftClient MC = MinecraftClient.getInstance();
    public static final ClientPlayerInteractionManager CPIM = MC.interactionManager;
    private EventManager eventManager;

    public void initialize() {
        eventManager = new EventManager();
        new ChatParser();
    }

    public EventManager getEventManager() {
        return eventManager;
    }


    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }
}
