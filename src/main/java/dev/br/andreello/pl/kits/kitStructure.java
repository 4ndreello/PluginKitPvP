package dev.br.andreello.pl.kits;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.events.SequenceStartEvent;

public class kitStructure {
    static class TKitStruct {
        ItemStack item;
        Integer positionY = -1;
        Integer positionX = -1;
    }

    static class TInventoryStruct {
        int[][] inventory = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        public void add(Integer pX, Integer pY) {
            if (pY > 4) return;
            if (pX > 9) return;

            System.out.println("py " + pY);
            System.out.println("px " +pX);

            if (pY != -1 && pX != -1) {
                inventory[pY - 1][pX - 1] = 1;
                return;
            }

            int nY = -1;
            int nX = -1;

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 9; x++) {
                    if (inventory[y][x] == 0) {
                        nY = y;
                        nX = x;
                        break;
                    }
                }
                if (nY != -1) break;
            }

            inventory[nY][nX] = 1;
        }
    }

    public ItemStack[] get() {
        return null;
    }
    public void generate(TKitStruct[] data) {
        TInventoryStruct newInv = new TInventoryStruct();
        for (TKitStruct datum : data) {
            newInv.add(datum.positionX, datum.positionY);
        }

        int itens = 0;
        int sopas = 0;

        for (int i = 0; i < newInv.inventory.length; i++) {
            for (int k = 0; k < newInv.inventory[i].length; k++) {
                if (newInv.inventory[i][k] != 0) {
                    itens++;
                } else {
                    System.out.println("x -> " + k + " | y -> " + i);
                    sopas++;
                }
            }
        }

        System.out.println("Voce tem " + itens + " itens e " + sopas + " sopas");
    }
}
