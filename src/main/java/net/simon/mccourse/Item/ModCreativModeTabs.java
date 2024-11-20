package net.simon.mccourse.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.simon.mccourse.MCCourseMod;
import net.simon.mccourse.block.ModBlocks;

public class ModCreativModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public  static final RegistryObject<CreativeModeTab> Course_Tab = CREATIVE_MODE_TABS.register("course_tab",
            ()->  CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.Alexandrite.get())).title(Component.translatable("creativetab.course_tab")).displayItems((Parameters, Output) -> {
              Output.accept(ModItems.Alexandrite.get());
                Output.accept(ModItems.RAW_Alexandrite.get());
                Output.accept(ModBlocks.Alexandrite_Block.get());
                Output.accept(ModBlocks.Raw_Alexandrite_Block.get());
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
