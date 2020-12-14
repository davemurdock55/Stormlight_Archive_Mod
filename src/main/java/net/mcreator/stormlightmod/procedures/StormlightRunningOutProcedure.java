package net.mcreator.stormlightmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class StormlightRunningOutProcedure extends StormlightModModElements.ModElement {
	public StormlightRunningOutProcedure(StormlightModModElements instance) {
		super(instance, 163);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure StormlightRunningOut!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt) > 0)) {
			{
				double _setval = (double) (((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt) - 1);
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stormlightConsumedAmnt = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
