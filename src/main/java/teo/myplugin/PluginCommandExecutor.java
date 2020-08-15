package teo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class PluginCommandExecutor implements CommandExecutor {
    final private MainPlugin plugin;

    public PluginCommandExecutor(MainPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        command.setUsage("");
        if(command.getName().equalsIgnoreCase("aci")  ){
            if( args.length == 0){
                if(plugin.aci.enabled){
                plugin.aci.enabled = false;
                Bukkit.broadcastMessage("AutoCollectItem disabled");
                }
                else{
                plugin.aci.enabled = true;
                Bukkit.broadcastMessage("AutoCollectItem enabled");
                }
            }
            else {
                if(args[0].equalsIgnoreCase("info")){
                     Bukkit.broadcastMessage("AutoCollectItem enabled: " + plugin.aci.enabled);
                }

            }
        }
        else if (command.getName().equalsIgnoreCase("randomhp") ) {
            if(plugin.scheduler== null){
                plugin.scheduler = getServer().getScheduler();
                plugin.scheduler.runTaskTimer(plugin, new RandomHP(), 100, 100);
            } else{
                plugin.scheduler.cancelTasks(plugin);
                plugin.scheduler = null;
            }
        }
        return false;
    }
}
