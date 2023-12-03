package andrealeet.mixin.client;

import andrealeet.mixininterfaces.IClickSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClickSlotC2SPacket.class)
public class ClickSlotC2SPacketMixin implements IClickSlot {


    @Final
    @Mutable
    @Shadow
    private ItemStack stack;

    @Final
    @Mutable
    @Shadow
    private int slot;

    public void setItemStack(ItemStack itemStack) {
        stack = itemStack;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}