package net.zach.bulletarmorenchant;

import net.minecraft.commands.arguments.ResourceKeyArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

import javax.swing.text.JTextComponent;

public class CustomDamageType {
    public static final ResourceKey<DamageType> BULLET = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("tacz", "bullet"));
    public static final ResourceKey<DamageType> BULLET_IGNORE_ARMOR = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("tacz", "bullet"));
}
