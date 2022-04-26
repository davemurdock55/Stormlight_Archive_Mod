
package net.mcreator.stormlightmod.keybind;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;

import net.mcreator.stormlightmod.procedures.ElsecallerpowerOnKeyPressedProcedure;
import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.stream.Stream;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@StormlightModModElements.ModElement.Tag
public class ElsecallerpowerKeyBinding extends StormlightModModElements.ModElement {
	@OnlyIn(Dist.CLIENT)
	private KeyBinding keys;

	public ElsecallerpowerKeyBinding(StormlightModModElements instance) {
		super(instance, 386);
		elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
				KeyBindingPressedMessage::handler);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		keys = new KeyBinding("key.stormlight_mod.elsecallerpower", GLFW.GLFW_KEY_T, "key.categories.misc");
		ClientRegistry.registerKeyBinding(keys);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (Minecraft.getInstance().currentScreen == null) {
			if (event.getKey() == keys.getKey().getKeyCode()) {
				if (event.getAction() == GLFW.GLFW_PRESS) {
					StormlightModMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
					pressAction(Minecraft.getInstance().player, 0, 0);
				}
			}
		}
	}

	public static class KeyBindingPressedMessage {
		int type, pressedms;

		public KeyBindingPressedMessage(int type, int pressedms) {
			this.type = type;
			this.pressedms = pressedms;
		}

		public KeyBindingPressedMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.pressedms = buffer.readInt();
		}

		public static void buffer(KeyBindingPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeInt(message.pressedms);
		}

		public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				pressAction(context.getSender(), message.type, message.pressedms);
			});
			context.setPacketHandled(true);
		}
	}

	private static void pressAction(PlayerEntity entity, int type, int pressedms) {
		World world = entity.world;
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (type == 0) {

			ElsecallerpowerOnKeyPressedProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
