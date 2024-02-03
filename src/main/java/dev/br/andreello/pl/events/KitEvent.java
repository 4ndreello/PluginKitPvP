package dev.br.andreello.pl.events;

import dev.br.andreello.pl.kits.Archer;
import dev.br.andreello.pl.kits.Noob;
import dev.br.andreello.pl.kits.kitStructure;
import dev.br.andreello.pl.utils.Sender;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class KitEvent implements Listener {
    double x;
    double y;

    @EventHandler
    public void openKits(PlayerInteractEvent event) {
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

    @EventHandler
    public void selectKit(InventoryClickEvent e) {
        if (e.getInventory() == null ||
            e.getInventory().getType() != InventoryType.CHEST ||
            e.getCurrentItem() == null ||
            e.getCurrentItem().getItemMeta() == null
        ) {
            return;
        }

        e.setCancelled(true);

        String kitName = e.getCurrentItem()
                .getItemMeta()
                .getDisplayName();

        setItems(e, kitName);
    }

    public void setItems(InventoryClickEvent e, String kitName) {
        System.out.println("Evento ocorrendo");
        if (kitName == null) return;
        try {
            kitStructure reference = null;

            switch (kitName.toLowerCase()) {
                case "noob":
                    reference = new Noob();
                    break;
                case "archer":
                    reference = new Archer();
                    break;
            }

            if (reference == null) return;
            if (reference.get() == null) return;

            e.getWhoClicked().closeInventory();

            e.getWhoClicked().getInventory().setContents(reference.get());
            new Sender(e.getWhoClicked()).send("Kit selecionado com sucesso");
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
        System.out.println("Evento acabou");
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
            if (i % 2 == 0) {
                vine[i] = new ItemStack(Material.DIAMOND_SWORD);
                vine[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1337);

                ItemMeta dirtMeta = vine[i].getItemMeta();
                dirtMeta.setDisplayName("Noob");

                vine[i].setItemMeta(dirtMeta);
            } else {
                vine[i] = new ItemStack(Material.BOW);

                ItemMeta dirtMeta = vine[i].getItemMeta();
                dirtMeta.setDisplayName("Archer");

                vine[i].setItemMeta(dirtMeta);
            }
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
