package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class ShatteredPlainsRainProcedure extends StormlightModModElements.ModElement {
	public ShatteredPlainsRainProcedure(StormlightModModElements instance) {
		super(instance, 132);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ShatteredPlainsRain!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getCurrentMoonPhaseFactor()) == 1)) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vec3d(0, 0, 0), Vec2f.ZERO,
						(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"weather thunder");
			}
		}
		if ((world.getWorld().isThundering())) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			World world = event.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
