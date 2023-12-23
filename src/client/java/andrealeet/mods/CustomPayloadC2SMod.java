package andrealeet.mods;

import andrealeet.ProtocolTestMod;
import andrealeet.listener.PacketListener;
import net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket;

public class CustomPayloadC2SMod implements PacketListener<CustomPayloadC2SPacket> {


    public CustomPayloadC2SMod() {
        ProtocolTestMod.INSTANCE.getPackedEventManager().add(CustomPayloadC2SPacket.class, this);
    }

    @Override
    public void onPacket(CustomPayloadC2SPacket packet) {
        if(ProtocolTestMod.INSTANCE.getPacketScreen() != null) ProtocolTestMod.INSTANCE.getPacketScreen().addPacket(packet);
    }
}
