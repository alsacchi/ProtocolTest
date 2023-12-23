package andrealeet;

import andrealeet.listener.EventManager;
import andrealeet.listener.PacketEventManager;
import andrealeet.mods.ChatParser;
import andrealeet.mods.CustomPayloadC2SMod;
import andrealeet.mods.CustomPayloadS2CMod;
import andrealeet.mods.TestMod;
import andrealeet.screens.PacketScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;

public enum ProtocolTestMod {
    INSTANCE;
    int iter = 0;
    public static final MinecraftClient MC = MinecraftClient.getInstance();
    public static final ClientPlayerInteractionManager CPIM = MC.interactionManager;
    private EventManager eventManager;
    private PacketEventManager packetEventManager;

    private PacketScreen packetScreen;


//    private TestMod testMod =
//    private ChatParser chatParser =

    public void initialize() {
        eventManager = new EventManager();
        packetEventManager = new PacketEventManager();
        new TestMod();
        new ChatParser();
        new CustomPayloadC2SMod();
        new CustomPayloadS2CMod();

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

    public PacketScreen getPacketScreen() {
        return packetScreen;
    }

    public void setPacketScreen(PacketScreen packetScreen) {
        this.packetScreen = packetScreen;
    }

}
