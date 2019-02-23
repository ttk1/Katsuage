package net.ttk1.katsuage.listener;

import com.google.inject.Singleton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

@Singleton
public class PlayerInteractEntityEventListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEventHandler(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getHand().equals(EquipmentSlot.HAND) &&
                player.getInventory().getItemInMainHand().getType().equals(Material.STICK)) {
            player.sendMessage("hello, world!");
        }
    }
}
