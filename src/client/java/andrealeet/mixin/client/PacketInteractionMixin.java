package andrealeet.mixin.client;

import andrealeet.ProtocolTestMod;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.CommonPongC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientCommonNetworkHandler.class)
public class PacketInteractionMixin {

	@Final
	@Shadow
	protected ClientConnection connection;

	@Inject(at = @At("HEAD"), method = "sendPacket")
	private void sendPacket(Packet<?> packet, CallbackInfo ci) {
			if(ProtocolTestMod.INSTANCE.getPacketScreen() != null && !(packet instanceof PlayerMoveC2SPacket) && !(packet instanceof CommonPongC2SPacket)) ProtocolTestMod.INSTANCE.getPacketScreen().addPacket(packet);
			ProtocolTestMod.INSTANCE.getPackedEventManager().fire(packet);
			


//		System.out.println("Packet of class! " + packet.getClass().toString());
//		if (packet instanceof ClickSlotC2SPacket csPacket) {
//			IClickSlot csPacketSet = (IClickSlot) csPacket;
//			csPacketSet.setItemStack(new ItemStack(Items.DIAMOND));
//			//csPacketSet.setSlot(csPacket.getSlot()-2);
//			System.out.printf("Slot: %d, ItemStack: %s, Action: %s\n", csPacket.getSlot(), csPacket.getStack(), csPacket.getActionType());
//			Int2ObjectMap<ItemStack> itemStackMap = csPacket.getModifiedStacks();
//			Int2ObjectMap<ItemStack> modifiedMap = new Int2ObjectArrayMap<ItemStack>(itemStackMap);
//			modifiedMap.replace(0, new ItemStack(Items.DIAMOND));
//			csPacketSet.setModifiedStack(modifiedMap);
//			itemStackMap = csPacket.getModifiedStacks();
//			for (int key : itemStackMap.keySet()) {
//				ItemStack itemStack = itemStackMap.get(key);
//				System.out.printf("Slot: %d, ItemStack: %s\n", key, itemStack);
//			}
//
//			for (int i = 0; i < ProtocolTestMod.INSTANCE.getIter(); i++)
//				connection.send(csPacket);
//		}
//		if (packet instanceof CraftRequestC2SPacket crPacket) {
//			System.out.printf("Recipe: %s\n", crPacket.getRecipe());
//			for (int i = 0; i < ProtocolTestMod.INSTANCE.getIter(); i++)
//				connection.send(crPacket);
//		}
	}
}