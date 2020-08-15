package teo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static org.bukkit.entity.EntityType.*;


public class HelloWorldPlugin implements Listener {



    @EventHandler
    public void onJoined(PlayerJoinEvent playerJoinEvent) {
        Bukkit.broadcastMessage(playerJoinEvent.getPlayer().getDisplayName() + " has joined!");
        playerJoinEvent.getPlayer().sendMessage("hello " +playerJoinEvent.getPlayer().getDisplayName() );

        playerJoinEvent.getPlayer().setMaxHealth(10);
        playerJoinEvent.getPlayer().setHealthScale(10);
        playerJoinEvent.getPlayer().setHealthScaled(true);

    }

//    @EventHandler
//    public void onStart(Player p) {
//
//    }

//    @EventHandler
//    public void onPl(PluginEnableEvent pluginEnableEvent){
//        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp set @a 99999 levels");
//    }
//
//
//
//
//    @EventHandler
//    public void onExp(PlayerExpChangeEvent playerExpChangeEvent){
//        Player player = (Player) playerExpChangeEvent.getPlayer();
//        if(player.getExpToLevel() == 99999){
//            player.setLevel(0);
//            player.setMaxHealth(1.5);
//            player.setHealthScale(1.5);
//            player.setHealthScaled(true);
//        }
//    }






    @EventHandler
    public void respawn(PlayerRespawnEvent playerRespawnEvent){
        playerRespawnEvent.getPlayer().setMaxHealth(0.5);
        playerRespawnEvent.getPlayer().setHealthScale(0.5);
        playerRespawnEvent.getPlayer().setHealthScaled(true);

    }

//    @EventHandler
//    public void phablock(BlockBreakEvent blockBreakEvent){
//        blockBreakEvent.getPlayer().sendMessage("You broke " + blockBreakEvent.getBlock().getType().name());
//        if(blockBreakEvent.getBlock().getType().name().equals("SUGAR_CANE_BLOCK")){
//            blockBreakEvent.setDropItems(false);
////                for(int i=0;i<10;i++){
////
////                }
//            blockBreakEvent.getPlayer().getInventory().addItem(new ItemStack(blockBreakEvent.getBlock().getType()));
//        }
//        else{blockBreakEvent.getPlayer().sendMessage("12345");}
//    }

    @EventHandler
    public void monster(CreatureSpawnEvent creatureSpawnEvent){
        if (creatureSpawnEvent.getEntityType().equals(ZOMBIE)) {
            Zombie zombie = (Zombie) creatureSpawnEvent.getEntity();
                    zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_INGOT));

                    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
                    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                    zombie.getEquipment().setBoots(boots);
                    zombie.getEquipment().setBootsDropChance(1);
                    PotionEffect potion1 = new PotionEffect(PotionEffectType.GLOWING,20,1);
                    zombie.addPotionEffect(potion1);
                    zombie.setCustomName("Dumb");
                    zombie.setBaby(true);
        }

        if (creatureSpawnEvent.getEntityType().equals(CREEPER)) {
            Creeper creeper = (Creeper) creatureSpawnEvent.getEntity();
            creeper.setPowered(true);
        }
    }


}
