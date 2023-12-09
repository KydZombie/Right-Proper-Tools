package com.kydzombie.rpt.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class CustomTool extends ItemTool {
    private static final ToolMaterial JUNK_MATERIAL = EnumHelper.addToolMaterial("rpt_junk_material", 0, 0, 0f, 0f, 0);
    String[] types;
    Set<String> toolClasses;
    public CustomTool(String[] types, int miningLevel, float miningSpeed, int durability, float damage) {
        super(damage, JUNK_MATERIAL, Sets.newHashSet());
        this.types = types;
        toolClasses = Sets.newHashSet();
        for (String type : types) {
            toolClasses.add(type);
            this.setHarvestLevel(type, miningLevel);
        }
        this.efficiencyOnProperMaterial = miningSpeed;
        setMaxDamage(durability);
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return toolClasses;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, block, meta);
    }
}
