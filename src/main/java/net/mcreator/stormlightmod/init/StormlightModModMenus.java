
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<HssssssssMenu> HSSSSSSSS = register("hssssssss", (id, inv, extraData) -> new HssssssssMenu(id, inv, extraData));
	public static final MenuType<SkybreakerMenu> SKYBREAKER = register("skybreaker", (id, inv, extraData) -> new SkybreakerMenu(id, inv, extraData));
	public static final MenuType<CultivationMenu> CULTIVATION = register("cultivation",
			(id, inv, extraData) -> new CultivationMenu(id, inv, extraData));
	public static final MenuType<TruthwatchersprenspawningMenu> TRUTHWATCHERSPRENSPAWNING = register("truthwatchersprenspawning",
			(id, inv, extraData) -> new TruthwatchersprenspawningMenu(id, inv, extraData));
	public static final MenuType<OathGateMenu> OATH_GATE = register("oath_gate", (id, inv, extraData) -> new OathGateMenu(id, inv, extraData));
	public static final MenuType<ElsecallerMenu> ELSECALLER = register("elsecaller", (id, inv, extraData) -> new ElsecallerMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
