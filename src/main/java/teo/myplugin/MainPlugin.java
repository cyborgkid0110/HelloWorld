package teo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Random;


public class MainPlugin extends JavaPlugin implements Listener { //Extending JavaPlugin so that Bukkit knows its the main class...
    public AutoCollectItem aci  = new AutoCollectItem();
    public PluginCommandExecutor pce = new PluginCommandExecutor(this);
    private static Plugin plugin;
    public BukkitScheduler scheduler;

    public void onEnable() {

        registerEvents(this, aci, new HelloWorldPlugin());
        Bukkit.broadcastMessage("AWS Manager Plugin Started!");
        
        scheduler = getServer().getScheduler();
        scheduler.runTaskTimer(this, new RandomHP()
                , 100, 100);

        // Registers our echo command executor
        this.getCommand("echo").setExecutor(new EchoCommandExecutor());
        this.getCommand("aci").setExecutor(pce);
        this.getCommand("randomhp").setExecutor(pce);
        plugin = this;
    //This is where we register our events/commands
    }

    public void onDisable() {
        plugin = null;//To stop memory leeks

    }


    //Much easier then registering events in 10 different methods
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    //To access the plugin variable from other classes
    public static Plugin getPlugin() {
        return plugin;
    }




}
