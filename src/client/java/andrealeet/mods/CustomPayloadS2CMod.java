package andrealeet.mods;

import andrealeet.ProtocolTestMod;
import andrealeet.listener.PacketListener;
import net.minecraft.network.packet.s2c.common.CustomPayloadS2CPacket;

public class CustomPayloadS2CMod implements PacketListener<CustomPayloadS2CPacket> {
    public CustomPayloadS2CMod() {
        ProtocolTestMod.INSTANCE.getPackedEventManager().add(CustomPayloadS2CPacket.class, this);
    }

    @Override
    public void onPacket(CustomPayloadS2CPacket packet) {
        if(ProtocolTestMod.INSTANCE.getPacketScreen() != null) ProtocolTestMod.INSTANCE.getPacketScreen().addPacket(packet);
    }
}
