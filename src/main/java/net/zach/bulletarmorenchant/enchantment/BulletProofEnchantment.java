package net.zach.bulletarmorenchant.enchantment;

import com.mojang.datafixers.kinds.App;
import net.minecraft.core.Registry;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;

public class BulletProofEnchantment extends Enchantment {
        public final BulletProofEnchantment.Type type;

        public BulletProofEnchantment(Enchantment.Rarity Rarity, Type type, EquipmentSlot... applicableSlots) {
            super(Rarity, EnchantmentCategory.ARMOR, applicableSlots);
            this.type = type;
        }

    public int getMinCost(int pEnchantmentLevel) {
        return this.type.getMinCost() + (pEnchantmentLevel - 1) * this.type.getLevelCost();
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + this.type.getLevelCost();
    }

    public int getMaxLevel() {
        return 5;
    }

    public int getDamageProtection(int pLevel, DamageSource pSource) {
        if (pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return 0;
        } else if (this.type == BulletProofEnchantment.Type.BULLET) {
            return 2*pLevel;
        } else if (this.type == BulletProofEnchantment.Type.BULLET_IGNORE_ARMOR) {
            return 2*pLevel;
        } else {
            return 0;
        }
    }

    /*public static double getExplosionKnockbackAfterDampener(LivingEntity pLivingEntity, double pDamage) {
        int $$2 = EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, pLivingEntity);
        if ($$2 > 0) {
            pDamage *= Mth.clamp(1.0 - (double)$$2 * 0.15, 0.0, 1.0);
        }

        return pDamage;
    }*/

    public static enum Type {
        BULLET_IGNORE_ARMOR(1, 8),
        BULLET(1, 8);


        private final int minCost;
        private final int levelCost;

        private Type(int pMinCost, int pLevelCost) {
            this.minCost = pMinCost;
            this.levelCost = pLevelCost;
        }

        public int getMinCost() {
            return this.minCost;
        }

        public int getLevelCost() {
            return this.levelCost;
        }
    }
}