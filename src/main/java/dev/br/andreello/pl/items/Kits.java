package dev.br.andreello.pl.items;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Kits implements Listener {
    double x;
    double y;

    @EventHandler
    public void openKit(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();

        if (block == null ||
            event.getAction() != Action.RIGHT_CLICK_BLOCK ||
            block.getType() != Material.CHEST) {
            return;
        }

        Chest c = (Chest) block.getState();

        x = c.getLocation().getX();
        y = c.getLocation().getX();

        c.getBlockInventory().setContents(generateChestItems());
    }

    private ItemStack[] generateChestItems() {
        ItemStack[] chestItems = Stream.concat(Arrays.stream(genFirstLine()), Arrays.stream(genSecondLine()))
                .toArray(size -> (ItemStack[]) Array.newInstance(genFirstLine().getClass().getComponentType(), size));

        return Stream.concat(Arrays.stream(chestItems), Arrays.stream(genThirdLine()))
                .toArray(size -> (ItemStack[]) Array.newInstance(chestItems.getClass().getComponentType(), size));
    }

    private ItemStack[] genThirdLine() {
        ItemStack[] vine = new ItemStack[9];

        for (int i = 0; i < vine.length; i++) {
            vine[i] = new ItemStack(Material.VINE);
            vine[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1337);
        }

        return vine;
    }

    private ItemStack[] genSecondLine() {
        ItemStack[] vine = new ItemStack[9];

        for (int i = 0; i < vine.length; i++) {
            vine[i] = new ItemStack(Material.DIAMOND_SWORD);
            vine[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1337);

            ItemMeta dirtMeta = vine[i].getItemMeta();
            dirtMeta.setDisplayName("Noob");

            vine[i].setItemMeta(dirtMeta);
        }

        return vine;
    }

    private ItemStack[] genFirstLine() {
        ItemStack[] vine = new ItemStack[9];

        for (int i = 0; i < vine.length; i++) {
            vine[i] = new ItemStack(Material.VINE);
            vine[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1337);
        }

        return vine;
    }
}
