package andrealeet.listener;

import net.minecraft.network.packet.Packet;

public interface PacketListener<P extends Packet<?>>  {
    void onPacket(P packet);

}
