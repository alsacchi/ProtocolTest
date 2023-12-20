package andrealeet.mixin.client;

import andrealeet.mixininterfaces.IClickSlot;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
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

    @Final
    @Mutable
    @Shadow
    private Int2ObjectMap<ItemStack> modifiedStacks;

    @Final
    @Mutable
    @Shadow
    private SlotActionType actionType;
    public void protocolTest$setItemStack(ItemStack itemStack) {
        stack = itemStack;
    }

    public void protocolTest$setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public void protocolTest$setModifiedStack(Int2ObjectMap<ItemStack> itemStackMap) {
        this.modifiedStacks = itemStackMap;
    }

    @Override
    public void protocolTest$setAction(SlotActionType action) {
        this.actionType = action;
    }
}