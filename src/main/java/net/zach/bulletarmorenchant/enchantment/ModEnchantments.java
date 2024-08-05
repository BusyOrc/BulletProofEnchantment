package net.zach.bulletarmorenchant.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zach.bulletarmorenchant.BulletArmorEnchant;


public class ModEnchantments {
    // Create Deferred Register for Enchantments
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BulletArmorEnchant.MOD_ID);

    // Register your enchantment
    public static final RegistryObject<Enchantment> BULLET_PROOF = ENCHANTMENTS.register("bullet_proof", () -> new BulletProofEnchantment(
            Enchantment.Rarity.UNCOMMON, BulletProofEnchantment.Type.BULLET, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.HEAD, EquipmentSlot.FEET
    ));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}

