package teo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EchoCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.broadcastMessage(String.format("Echo: sender name [%s] command name [%s] args [%s]",
                sender.getName(),
                command.getName(),
                String.join(",", args)));

        return false;
    }
}
