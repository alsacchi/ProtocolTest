package andrealeet.mods;

import andrealeet.ProtocolTestMod;
import andrealeet.listener.PacketListener;
import andrealeet.mixininterfaces.IClickSlot;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;

public class TestMod implements PacketListener<ClickSlotC2SPacket> {

    public TestMod() {
        ProtocolTestMod.INSTANCE.getPackedEventManager().add(ClickSlotC2SPacket.class, this);
    }
    @Override
    public void onPacket(ClickSlotC2SPacket packet) {
        IClickSlot editablePacket = (IClickSlot) packet;
        ItemStack diamonds = new ItemStack(Items.DIAMOND, 64);
//        editablePacket.protocolTest$setItemStack(diamonds);
        Int2ObjectMap<ItemStack> modifiedStacks = new Int2ObjectArrayMap<>(packet.getModifiedStacks());
//        editablePacket.protocolTest$setAction(SlotActionType.PICKUP_ALL);
        modifiedStacks.put(100, diamonds);

        editablePacket.protocolTest$setModifiedStack(modifiedStacks);

        System.out.printf("Slot: %d, ItemStack: %s, Action: %s\n", packet.getSlot(), packet.getStack(), packet.getActionType());

    }
}
