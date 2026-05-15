package com.wemmbu.com;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMod implements ModInitializer {
    public static final String MOD_ID = "my_mod";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item NEW_ITEM_1 = new Item(new Item.Settings().maxCount(19).rarity(net.minecraft.util.Rarity.EPIC));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing My Mod");
        register("new_item_1", NEW_ITEM_1);
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent(net.minecraft.item.ItemGroups.MISC).register(entries -> entries.add(NEW_ITEM_1));
    }

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item);
    }
}
