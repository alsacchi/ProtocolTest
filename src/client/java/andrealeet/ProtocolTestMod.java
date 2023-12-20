package andrealeet;

import andrealeet.listener.EventManager;
import andrealeet.listener.PacketEventManager;
import andrealeet.mods.ChatParser;
import andrealeet.mods.TestMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;

public enum ProtocolTestMod {
    INSTANCE;
    int iter = 0;
    public static final MinecraftClient MC = MinecraftClient.getInstance();
    public static final ClientPlayerInteractionManager CPIM = MC.interactionManager;
    private EventManager eventManager;
    private PacketEventManager packetEventManager;

//    private TestMod testMod =
//    private ChatParser chatParser =

    public void initialize() {
        eventManager = new EventManager();
        packetEventManager = new PacketEventManager();
        new TestMod();
        new ChatParser();

    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public PacketEventManager getPackedEventManager() {
        return packetEventManager;
    }


    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }
}
