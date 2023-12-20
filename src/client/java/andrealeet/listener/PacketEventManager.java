package andrealeet.listener;

import net.minecraft.network.packet.Packet;

import java.util.ArrayList;
import java.util.HashMap;

public class PacketEventManager {

    public final HashMap<Class<? extends Packet<?>>, ArrayList<? extends PacketListener<?>>> listenerMap = new HashMap<>();

    public PacketEventManager() {
    }

    @SuppressWarnings("unchecked")
    public <P extends Packet<?>,L extends PacketListener<P>> void add(Class<P> type, L listener) {
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if (listeners == null) {
            listeners = new ArrayList<>();
            listenerMap.put(type, listeners);
        }
        listeners.add(listener);
    }

    @SuppressWarnings("unchecked")
    public <P extends Packet<?>,L extends PacketListener<P>> void remove(Class<P> type, L listener) {
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public <P extends Packet<?>, L extends PacketListener<P>> void fire(P packet) {
        Class<P> type = (Class<P>) packet.getClass();
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if(listeners == null || listeners.isEmpty()) return;

        for(L listener : listeners) {
            listener.onPacket(packet);
        }
    }


}
