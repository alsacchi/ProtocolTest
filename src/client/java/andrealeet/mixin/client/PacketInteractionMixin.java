package andrealeet.mixin.client;

import andrealeet.ProtocolTestClient;
import andrealeet.ProtocolTestMod;
import andrealeet.mixininterfaces.IClickSlot;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientCommonNetworkHandler.class)
public class PacketInteractionMixin {

	@Shadow
	private ClientConnection connection;

	@Inject(at = @At("HEAD"), method = "sendPacket")
	private void sendPacket(Packet<?> packet, CallbackInfo ci) {
		//System.out.println("Packet of class! " + packet.getClass().toString());
		if(packet instanceof ClickSlotC2SPacket csPacket) {
			IClickSlot csPacketSet = (IClickSlot) csPacket;
			//csPacketSet.setItemStack(new ItemStack(Items.DIAMOND));
			//csPacketSet.setSlot(csPacket.getSlot()-2);
			System.out.printf("Slot: %d, ItemStack: %s, Action: %s\n", csPacket.getSlot(), csPacket.getStack(), csPacket.getActionType());
			for(int i = 0; i < ProtocolTestMod.INSTANCE.getIter(); i++)
				connection.send(csPacket);
		}
	}
}