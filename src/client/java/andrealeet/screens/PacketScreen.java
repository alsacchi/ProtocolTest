package andrealeet.screens;

import andrealeet.ProtocolTestMod;
import andrealeet.screens.widgets.PacketListWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.MultilineTextWidget;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class PacketScreen extends Screen {

    private final List<Packet<?>> packets;
    private PacketListWidget packetWidget;
    private MultilineTextWidget multilineTextWidget;

    public PacketScreen() {
        super(Text.of("Packet Screen"));

        this.client = ProtocolTestMod.MC;

        packets = new ArrayList<>();


        //super.setTooltip(Text.of("Packet Screen"));
    }

    protected void init() {
        packetWidget = new PacketListWidget(ProtocolTestMod.MC, this.width / 4 + 10, this.height, 5, this.height - 5, 30, this, packets);
        this.addSelectableChild(this.packetWidget);
        this.addDrawableChild(ButtonWidget.builder(Text.of("X"), (button) ->  this.clear()).dimensions(this.width - 20, 0, 20, 20).build());
        multilineTextWidget = new MultilineTextWidget(this.width / 4 + 40, 0, Text.of(""), this.client.textRenderer);
        multilineTextWidget.setMaxWidth(500);
        multilineTextWidget.setCentered(true);
        this.addDrawableChild(multilineTextWidget);
//        for(int i = 0; i < 100; i++) {
//            packetWidget.addPacket(new PacketEntry(packetWidget, i + 1));
//        }
    }

    private void clear() {
        packets.clear();
        packetWidget.clear();
    }

    public void addPacket(Packet<?> packet) {
        packets.add(packet);
        this.packetWidget.addPacket(packet);
    }

    public MultilineTextWidget getMultilineTextWidget() {
        return this.multilineTextWidget;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        //packetWidget.updateSize(ProtocolTestMod.MC.getWindow().getScaledWidth() / 4 + 10, ProtocolTestMod.MC.getWindow().getScaledHeight(), 5, ProtocolTestMod.MC.getWindow().getScaledHeight() - 5);
        this.packetWidget.render(context, mouseX, mouseY, delta);
    }


}
