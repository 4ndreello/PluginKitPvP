package dev.br.andreello.pl.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;

public class Sender {
    HumanEntity toSend = null;
    public Sender(HumanEntity send_to) {
        toSend = send_to;
    }

    public void send(String message) {
        if (toSend == null) return;
        toSend.sendMessage("[" + ChatColor.MAGIC + "KitPvP" + ChatColor.WHITE + "] " + ChatColor.AQUA + message);
    }
}
