package dev.br.andreello.pl.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Archer extends kitStructure {
    public ItemStack[] get() {
        TKitStruct stoneSword = new TKitStruct();
        stoneSword.item = new ItemStack(Material.STONE_SWORD);

        TKitStruct bow = new TKitStruct();
        bow.item = new ItemStack(Material.BOW);
        bow.item.addEnchantment(Enchantment.ARROW_FIRE, 1);

        TKitStruct arrows = new TKitStruct();
        arrows.item = new ItemStack(Material.ARROW, 64);
        arrows.positionY = 4;
        arrows.positionX = 1;

        this.generate(new TKitStruct[] { stoneSword, bow, arrows });

        return null;
    }
}
