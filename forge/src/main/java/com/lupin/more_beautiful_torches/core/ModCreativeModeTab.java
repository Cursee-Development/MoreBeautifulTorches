package com.lupin.more_beautiful_torches.core;

import com.lupin.more_beautiful_torches.CommonConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CommonConstants.MOD_ID);
	
	public static RegistryObject<CreativeModeTab> MOREBEAUTIFULTORCHES_TAB = CREATIVE_MODE_TABS.register("morebeautifultorches_tab", () ->
		CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ACACIA_LOG_TORCH_ITEM.get()))
			.title(Component.translatable("itemGroup.morebeautifultorches")).build());
	
	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
//    public static CreativeModeTab MOREBEAUTIFULTORCHES_TAB;

//    @SubscribeEvent
//    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
//        MOREBEAUTIFULTORCHES_TAB = event.registerCreativeModeTab(new ResourceLocation(MoreBeautifulTorches.MOD_ID, "morebeautifultorches"),
//                builder -> builder.icon(() -> new ItemStack(ModBlocks.ACACIA_LOG_TORCH_ITEM.get()))
//                        .title(Component.translatable("itemGroup.morebeautifultorches")));
//    }
}
