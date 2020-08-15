package teo.myplugin;

import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoCollectItem implements Listener{
public boolean enabled = false ;

    @EventHandler
    public void collectitem(BlockBreakEvent blockBreakEvent) {
                if(enabled) {
                    switch (blockBreakEvent.getBlock().getType()) {
                        case ACACIA_LEAVES:

                            break;
                        case BIRCH_LEAVES:

                            break;
                        case DARK_OAK_LEAVES:

                            break;
                        case JUNGLE_LEAVES:
                            break;
                        case OAK_LEAVES:
                            break;
                        case SPRUCE_LEAVES:
                            break;

                        default:
                            blockBreakEvent.setDropItems(false);
                            blockBreakEvent.getBlock().getDrops().forEach((x) -> {
                                        blockBreakEvent.setDropItems(false);
                                        blockBreakEvent.getPlayer().getInventory().addItem(x);
                                    }
                            );

                            break;
                    }
                }

        }


}