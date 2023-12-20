package andrealeet.listeners;

import andrealeet.listener.CancellableEvent;

import java.util.ArrayList;

public class ChatEvent extends CancellableEvent<ChatListener> {
    private final String originalMessage;
    private String message;

    public ChatEvent(String message) {
        this.message = message;
        this.originalMessage = message;
    }

    @Override
    public void fire(ArrayList<ChatListener> listeners) {
        for(ChatListener listener : listeners) {
            listener.onChatMessage(this);
        }
    }

    @Override
    public Class<ChatListener> getListenerType() {
        return ChatListener.class;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isModifed() {
        return !originalMessage.equals(message);
    }
}
