package com.jaguth.spigotpluggin.helloworld;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class HelloWorldPluggin extends JavaPlugin implements Listener {
    @Override
    public void onEnable()
    {
        // Registers the event handlers. Scans this class for all "EventHandler" annotations
        Bukkit.getPluginManager().registerEvents(this, this);

        Bukkit.broadcastMessage("AWS Manager Pluggin Started!");


        // Registers our echo command executor
        this.getCommand("echo").setExecutor(new EchoCommandExecutor());
    }

    @EventHandler
    public void onJoined(PlayerJoinEvent playerJoinEvent) {
        Bukkit.broadcastMessage(playerJoinEvent.getPlayer().getDisplayName() + " has joined!");
        playerJoinEvent.getPlayer().sendMessage("hello " +playerJoinEvent.getPlayer().getDisplayName() );
        playerJoinEvent.getPlayer().setMaxHealth(0.5);
        playerJoinEvent.getPlayer().setHealthScale(0.5);
        playerJoinEvent.getPlayer().setHealthScaled(true);

    }

    @EventHandler
    public void respawn(PlayerRespawnEvent playerRespawnEvent){
        playerRespawnEvent.getPlayer().setMaxHealth(0.5);
        playerRespawnEvent.getPlayer().setHealthScale(0.5);
        playerRespawnEvent.getPlayer().setHealthScaled(true);

    }

    @EventHandler
    public void phablock(BlockBreakEvent blockBreakEvent){
        blockBreakEvent.getPlayer().sendMessage("You broke " + blockBreakEvent.getBlock().getType().name());
        if(blockBreakEvent.getBlock().getType().name().equals("SUGAR_CANE_BLOCK")){
            blockBreakEvent.setDropItems(false);
//                for(int i=0;i<10;i++){
//
//                }
            blockBreakEvent.getPlayer().getInventory().addItem(new ItemStack(blockBreakEvent.getBlock().getType()));
        }
        else{blockBreakEvent.getPlayer().sendMessage("12345");}
    }

    @EventHandler
    public void dingu(PlayerBedEnterEvent playerBedEnterEvent){
        playerBedEnterEvent.getPlayer().sendMessage("Ngu ngon nhe");
    }


}
