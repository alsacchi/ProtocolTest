package andrealeet.mixin.client;

import andrealeet.ProtocolTestMod;
import andrealeet.screens.PacketScreen;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Keyboard.class)
public class KeyboardMixin {


    @Inject(at = @At("HEAD"), method = "processF3", cancellable = true)
    private void processF3(int key, CallbackInfoReturnable<Boolean> ci) {
        switch(key) {
            case 78:
                ProtocolTestMod.MC.setScreen(new PacketScreen());
                ci.setReturnValue(true);
                break;
        }
    }

}
