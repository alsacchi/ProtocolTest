package andrealeet.listener;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    public final HashMap<Class<? extends Listener>, ArrayList<? extends Listener>> listenerMap = new HashMap<>();

    public EventManager() {
    }

    @SuppressWarnings("unchecked")
    public <L extends Listener> void add(Class<L> type, L listener) {
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if (listeners == null) {
            listeners = new ArrayList<>();
            listenerMap.put(type, listeners);
        }
        listeners.add(listener);
    }

    @SuppressWarnings("unchecked")
    public <L extends Listener> void remove(Class<L> type, L listener) {
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public <L extends Listener, E extends Event<L>> void fire(E event) {
        Class<L> type = event.getListenerType();
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);
        if(listeners == null || listeners.isEmpty()) return;

        event.fire(listeners);
    }


}
