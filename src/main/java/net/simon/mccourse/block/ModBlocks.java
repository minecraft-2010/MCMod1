package net.simon.mccourse.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.simon.mccourse.Item.ModItems;
import net.simon.mccourse.MCCourseMod;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final  RegistryObject<Block> Alexandrite_Block = registerBlock("alexandrite_block",
            ()-> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK)));

    public static final  RegistryObject<Block> Raw_Alexandrite_Block = registerBlock("raw_alexandrite_block",
            ()-> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toreturn = Blocks.register(name,block);
        registerblockitem(name,toreturn);
        return toreturn;
    }

    private static <T extends Block> RegistryObject<Item>  registerblockitem(String name,RegistryObject<T> block){
        return ModItems.Items.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        Blocks.register(eventBus);
    }
}
