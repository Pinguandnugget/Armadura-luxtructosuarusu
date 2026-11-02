package com.potitostudio.lux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.Map;

public class LuxMod implements ModInitializer {
    public static final String MODID = "luxtructosaurus";
    private static final ArmorMaterial MATERIAL = new ArmorMaterial(
        Map.of(ArmorItem.Type.HELMET, 4, ArmorItem.Type.CHESTPLATE, 9,
               ArmorItem.Type.LEGGINGS, 7, ArmorItem.Type.BOOTS, 4,
               ArmorItem.Type.BODY, 0),
        10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        () -> Ingredient.ofItems(Items.DIAMOND),
        List.of(new ArmorMaterial.Layer(Identifier.of(MODID, "luxtructosaurus"))),
        2.0f, 0.0f);
    private static RegistryEntry<ArmorMaterial> armorMaterial;
    public static Item TEMPLATE, HELMET, CHESTPLATE, LEGGINGS, BOOTS;
    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MODID, id), item);
    }
    @Override public void onInitialize() {
        armorMaterial = Registry.registerReference(Registries.ARMOR_MATERIAL,
             Identifier.of(MODID, "luxtructosaurus"), MATERIAL);
        TEMPLATE = register("plantilla_luxtructosaurus", new Item(new Item.Settings()));
        HELMET = register("casco_luxtructosaurus", new ArmorItem(armorMaterial, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
        CHESTPLATE = register("peto_luxtructosaurus", new ArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
        LEGGINGS = register("pantalones_luxtructosaurus", new ArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
        BOOTS = register("botas_luxtructosaurus", new ArmorItem(armorMaterial, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(e -> {
            e.add(TEMPLATE); e.add(HELMET); e.add(CHESTPLATE); e.add(LEGGINGS); e.add(BOOTS);
        });
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTicks() % 5 != 0) return;
            for (var player : server.getPlayerManager().getPlayerList()) {
                boolean full = player.getEquippedStack(EquipmentSlot.HEAD).isOf(HELMET)
                    && player.getEquippedStack(EquipmentSlot.CHEST).isOf(CHESTPLATE)
                    && player.getEquippedStack(EquipmentSlot.LEGS).isOf(LEGGINGS)
                    && player.getEquippedStack(EquipmentSlot.FEET).isOf(BOOTS);
                if (full) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 12, 0, true, false, true));
                    player.setFireTicks(0);
                }
            }
        });
    }
}
