package net.ttk1.katsuage.listener;

import com.google.inject.Singleton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

@Singleton
public class PlayerInteractEntityEventListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEventHandler(PlayerInteractEntityEvent event) {
        if (event.getHand().equals(EquipmentSlot.OFF_HAND)) {
            Player player = event.getPlayer();
            player.sendMessage("hello, world!");
        }
    }
}
