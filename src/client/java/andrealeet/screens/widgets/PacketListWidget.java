package andrealeet.screens.widgets;

import andrealeet.screens.PacketScreen;
import andrealeet.screens.entries.PacketEntry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PacketListWidget extends AlwaysSelectedEntryListWidget<PacketEntry> {

    private PacketScreen parent;
    public PacketListWidget(MinecraftClient client, int width, int height, int top, int bottom, int entryHeight, PacketScreen parent, List<Packet<?>> packets) {
        super(client, width, height, top, bottom, entryHeight);
        this.setLeftPos(10);
        this.setRenderBackground(false);
        packets.forEach(this::addPacket);
        this.parent = parent;

    }

    public void clear() {
        super.clearEntries();
    }

    public void addPacket(@NotNull Packet<?> packet) {
        this.addEntry(new PacketEntry(this, packet));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
//        if(this.getEntryCount() != this.packets.size()) this.update();
        PacketEntry selected = getSelectedOrNull();
        if(selected != null) this.parent.getMultilineTextWidget().setMessage(Text.of(ReflectionToStringBuilder.toString(selected.getPacket())));

    }


    @Override
    public int getRowWidth() {
        return super.getRowWidth();
    }
}
