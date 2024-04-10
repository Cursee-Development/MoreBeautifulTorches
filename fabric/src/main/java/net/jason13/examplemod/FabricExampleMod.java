package net.jason13.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jason13.examplemod.methods.BlockMethods;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;

public class FabricExampleMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        CommonConstants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        
        
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
    
    public class PlayerTickHandler implements ServerTickEvents.StartTick {
        @Override
        public void onStartTick(MinecraftServer server) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.isCrouching()) {
                    boolean leftHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getOffhandItem());
                    boolean rightHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getMainHandItem());
                    
                    if (leftHandCommand && rightHandCommand) {
                        player.sendSystemMessage(Component.literal("true command tick from " + CommonConstants.MOD_NAME));
                    }
                }
            }
        }
    }
}
