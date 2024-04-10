package net.jason13.examplemod;

import net.jason13.examplemod.methods.BlockMethods;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(CommonConstants.MOD_ID)
public class ForgeExampleMod {
    
    public ForgeExampleMod() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        CommonConstants.LOG.info("Hello Forge world!");
        CommonClass.init();
        
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onStartTick(TickEvent.ServerTickEvent event) {
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