package net.simon.mccourse.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.simon.mccourse.MCCourseMod;

public class ModItems {
    public static final DeferredRegister<Item> Items
            = DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> Alexandrite = Items.register("alexandrite",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_Alexandrite = Items.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }
}
