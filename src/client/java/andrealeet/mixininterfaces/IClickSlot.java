package andrealeet.mixininterfaces;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

public interface IClickSlot  {
    void protocolTest$setItemStack(ItemStack itemStack);
    void protocolTest$setSlot(int slot);

    void protocolTest$setModifiedStack(Int2ObjectMap<ItemStack> itemStackMap);

    void protocolTest$setAction(SlotActionType action);
}
