package andrealeet.mods;

import andrealeet.ProtocolTestMod;
import andrealeet.listeners.ChatEvent;
import andrealeet.listeners.ChatListener;

public class ChatParser implements ChatListener {

    public ChatParser() {
        ProtocolTestMod.INSTANCE.getEventManager().add(ChatListener.class, this);
    }
    @Override
    public void onChatMessage(ChatEvent event) {
        System.out.println(event.getMessage());
        if(event.getOriginalMessage().startsWith("/")) {
            if (event.getMessage().split(" ")[0].equals("/set")) {
                ProtocolTestMod.INSTANCE.setIter(Integer.parseInt(event.getMessage().split(" ")[1]));
                event.cancel();
            }
        }
    }
}
