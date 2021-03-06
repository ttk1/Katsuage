package net.ttk1.katsuage.listener;

import com.google.inject.Singleton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

@Singleton
public class InventoryOpenEventListener implements Listener {
    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        if (event.getInventory().getType() == InventoryType.MERCHANT &&
                event.getPlayer() instanceof Player &&
                event.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
            event.setCancelled(true);
        }
    }
}
