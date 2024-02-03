package dev.br.andreello.pl.events;

import dev.br.andreello.pl.utils.Sender;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener  {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        new Sender(e.getPlayer()).send("Seja bem vindo! Plugin de KitPvP");
    }
}
