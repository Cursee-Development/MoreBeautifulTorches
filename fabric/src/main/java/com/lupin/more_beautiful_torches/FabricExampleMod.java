package com.lupin.more_beautiful_torches;

import com.lupin.more_beautiful_torches.CommonClass;
import com.lupin.more_beautiful_torches.CommonConstants;
import com.lupin.more_beautiful_torches.core.ModBlocks;
import com.lupin.more_beautiful_torches.core.ModCreativeModeTab;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jason13.monolib.methods.BlockMethods;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;

public class FabricExampleMod implements ModInitializer {
    
    public boolean debuggingEnabled = false;
    
    @Override
    public void onInitialize() {
        
        CommonClass.init();
        
        ModBlocks.register();
        ModCreativeModeTab.register();
        
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        
    }
    
    public class PlayerTickHandler implements ServerTickEvents.StartTick {
        @Override
        public void onStartTick(MinecraftServer server) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                
                boolean leftHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getOffhandItem());
                boolean rightHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getMainHandItem());
                
                if (!debuggingEnabled && leftHandCommand && rightHandCommand) {
                    debuggingEnabled = true;
                    player.sendSystemMessage(Component.literal("debuggingEnabled" + CommonConstants.MOD_NAME));
                }
            }
        }
    }
}