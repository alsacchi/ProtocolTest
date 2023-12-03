package andrealeet.mixininterfaces;

import net.minecraft.item.ItemStack;

public interface IClickSlot  {
    void setItemStack(ItemStack itemStack);
    void setSlot(int slot);
}
