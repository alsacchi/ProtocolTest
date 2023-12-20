package andrealeet.screens;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.text.Text;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class PacketScreen extends Screen {
    public PacketScreen() {
        super(Text.of("Packet Screen"));
    }


    protected void init() {

    }

    public abstract static class Entry extends AlwaysSelectedEntryListWidget.Entry<Entry> implements AutoCloseable {
        public Entry() {
        }

        public void close() {
        }
    }

    public class PacketEntry extends Entry {

        @Override
        public Text getNarration() {
            return null;
        }

        @Override
        public void render(DrawContext context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            context.drawText(textRenderer, "Ciao test", x + 0, y + 0, 16777215, false);
        }
    }
    private class PacketListWidget extends AlwaysSelectedEntryListWidget<Entry> {
        private final List<PacketEntry> packets = Lists.newArrayList();
        public PacketListWidget(MinecraftClient client, int width, int height, int top, int bottom, int entryHeight) {
            super(client, width, height, top, bottom, entryHeight);

        }


    }



}
