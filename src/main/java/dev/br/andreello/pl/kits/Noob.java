package dev.br.andreello.pl.kits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Noob extends kitStructure {
    public ItemStack[] get() {
        return (new ItemStack[]{
                new ItemStack(Material.DIAMOND_SWORD),
                new ItemStack(Material.MUSHROOM_SOUP),
                new ItemStack(Material.MUSHROOM_SOUP),
                new ItemStack(Material.MUSHROOM_SOUP)
        });
    }
}
