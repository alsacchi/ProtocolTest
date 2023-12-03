package andrealeet.mixin.client;

import andrealeet.ProtocolTestClient;
import andrealeet.ProtocolTestMod;
import andrealeet.listeners.ChatEvent;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Inject(at = @At("HEAD"), method = "sendMessage", cancellable = true)
    public void sendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> ci) {
        ChatEvent event = new ChatEvent(chatText);
        ProtocolTestMod.INSTANCE.getEventManager().fire(event);
        if(event.isModifed()) chatText = event.getMessage();

        if(event.isCancelled())
            ci.cancel();
    }


}
