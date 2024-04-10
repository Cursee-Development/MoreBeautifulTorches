package net.jason13.examplemod;


import net.jason13.examplemod.methods.BlockMethods;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

@Mod(CommonConstants.MOD_ID)
public class NeoForgeExampleMod {

    public NeoForgeExampleMod(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        CommonConstants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
    }
    
    @Mod.EventBusSubscriber(modid = CommonConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class NeoEventBusListeners {
        @SubscribeEvent
        public static void onStartTick(TickEvent.ServerTickEvent event){
            if (event.phase == TickEvent.Phase.START) {
                for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                    if (player.isCrouching()) {
                        boolean leftHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getOffhandItem());
                        boolean rightHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getMainHandItem());
                        
                        if (leftHandCommand && rightHandCommand) {
                            player.sendSystemMessage(Component.literal("true command tick from " + CommonConstants.MOD_NAME));
                        }
                    }
                }
            }
            if (event.phase == TickEvent.Phase.END) {
                // empty
            }
        }
    }
}