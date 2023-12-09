package com.kydzombie.rpt.item;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class CustomToolBuilder {
    String name;
    String textureLocation;
    ArrayList<String> types = new ArrayList<>();
    int miningLevel = 0;
    float miningSpeed = 0;
    int durability;
    float damage;
    public CustomToolBuilder(String name, String primaryType, int durability) {
        this.name = name;
        this.types.add(primaryType);
        this.textureLocation = name;
        this.durability = durability;
    }

    public CustomToolBuilder withTextureLocation(String location) {
        this.textureLocation = location;
        return this;
    }

    public CustomToolBuilder withDamage(float damage) {
        this.damage = damage;
        return this;
    }

    public CustomToolBuilder withMiningStats(int miningLevel, float miningSpeed) {
        this.miningLevel = miningLevel;
        this.miningSpeed = miningSpeed;
        return this;
    }

    public CustomToolBuilder withType(String type) {
        types.add(type);
        return this;
    }

    public Item build() {
        Item tool = new CustomTool(types.toArray(new String[]{}), miningLevel, miningSpeed, durability, damage);
        tool.setUnlocalizedName(name);
        tool.setTextureName(textureLocation);
        return tool;
    }
}
