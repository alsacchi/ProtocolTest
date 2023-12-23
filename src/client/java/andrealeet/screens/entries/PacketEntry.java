package andrealeet.screens.entries;

import andrealeet.ProtocolTestMod;
import andrealeet.screens.widgets.PacketListWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class PacketEntry extends AlwaysSelectedEntryListWidget.Entry<PacketEntry> implements AutoCloseable {

    private final Packet<?> packet;
    private PacketListWidget parent;
    public PacketEntry(@NotNull PacketListWidget parent, @NotNull Packet<?> packet) {
        this.parent = parent;
        this.packet = packet;
    }

    @Override
    public Text getNarration() {
        return Text.of("Packet Entry");
    }

    @Override
    public void render(DrawContext context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
        context.drawText(ProtocolTestMod.MC.textRenderer, this.toString(), x + 2, y + 2, 16777215, false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        System.out.println("Mouse clicked on entry: " + this);
        this.parent.setSelected(this);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public String toString() {
        return "Pacchetto: " + packet.getClass().getSimpleName();
    }

    public @NotNull Packet<?> getPacket() {
        return packet;
    }

    public void setParent(PacketListWidget widget) {
        this.parent = widget;
    }
    @Override
    public void close() {
    }
}
