package net.mcreator.stormlightmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class StormlightMeterOverlayDisplayOverlayIngameProcedure extends StormlightModModElements.ModElement {
	public StormlightMeterOverlayDisplayOverlayIngameProcedure(StormlightModModElements instance) {
		super(instance, 412);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure StormlightMeterOverlayDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StormlightModModVariables.PlayerVariables())).radiantTrueFalse);
	}
}
