package net.simon.mccourse.Item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.simon.mccourse.block.ModBlocks;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide){
            BlockPos positionCliked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundblock = false;

            for (int i =0 ; i <= positionCliked.getY()+ 64; i++){
                BlockState blockState = pContext.getLevel().getBlockState(positionCliked.below(i));
                if (isValubleBlock(blockState)){
                    outputVariableeCordinats(positionCliked.below(i),player,blockState.getBlock());
                    foundblock = true;

                    break;
                }
            }
            if (!foundblock){
                outputNoVariableeFound(player);
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player ->
                player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    private void outputNoVariableeFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.mccourse.metal_detector.novaluables"));
    }

    private void outputVariableeCordinats(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valueble found"+ I18n.get(block.getDescriptionId()) +
                "at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")"));
    }

    private boolean isValubleBlock(BlockState blockState) {
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DEEPSLATE) || blockState.is(Blocks.DIAMOND_ORE) || blockState.is(ModBlocks.ALEXANDRITE_ORE.get());
    }
}
