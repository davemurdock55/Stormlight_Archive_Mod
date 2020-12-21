package net.mcreator.stormlightmod.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.Iterator;

@StormlightModModElements.ModElement.Tag
public class ShardbearerEntityDiesProcedure extends StormlightModModElements.ModElement {
	public ShardbearerEntityDiesProcedure(StormlightModModElements instance) {
		super(instance, 401);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure ShardbearerEntityDies!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("stormlight_mod:becominga_shardbearer"));
			AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
