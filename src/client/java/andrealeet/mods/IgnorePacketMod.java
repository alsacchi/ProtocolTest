package andrealeet.mods;

import net.minecraft.network.packet.Packet;

import java.util.HashSet;
import java.util.Set;

public class IgnorePacketMod {
    private final Set<Class<? extends Packet>> blacklist;

    public IgnorePacketMod() {
        blacklist = new HashSet<>();
    }

    public void addPacketClass(Class<? extends Packet> packetClass) {
        blacklist.add(packetClass);
    }

    public void removePacketClass(Class<? extends Packet> packetClass) {
        blacklist.remove(packetClass);
    }

    public boolean isBlacklisted(Class<? extends Packet> packetClass) {
        return blacklist.contains(packetClass);
    }

    public void togglePacketClass(Class<? extends Packet> packetClass) {
        if(isBlacklisted(packetClass)) {
            removePacketClass(packetClass);
        } else {
            addPacketClass(packetClass);
        }
    }
}
