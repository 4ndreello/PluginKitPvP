package dev.br.andreello.pl;

import dev.br.andreello.pl.items.Kits;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pl extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Loading plugin....");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new Kits(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin loaded!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("onEnable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println(command.getName());
        return false;
//        return super.onCommand(sender, command, label, args);
    }
}
