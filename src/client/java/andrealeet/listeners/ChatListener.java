package andrealeet.listeners;

import andrealeet.listener.Listener;

public interface ChatListener extends Listener {

    void onChatMessage(ChatEvent event);
}
