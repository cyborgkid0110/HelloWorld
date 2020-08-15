package teo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class RandomHP extends BukkitRunnable {


    public void run() {
        for (Player online : Bukkit.getOnlinePlayers()) {
            Random r = new Random();
            double randomValue = 0.5 + (10 - 0.5) * r.nextDouble();
            online.setMaxHealth(randomValue);
            online.setHealth(randomValue);
            online.setHealthScaled(true);
            online.setHealthScale(randomValue);
        }
    }
}