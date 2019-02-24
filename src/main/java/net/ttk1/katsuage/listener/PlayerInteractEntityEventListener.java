package net.ttk1.katsuage.listener;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.ttk1.katsuage.inventory.VillagerInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Logger;

@Singleton
public class PlayerInteractEntityEventListener implements Listener {
    private Logger logger;
    private JavaPlugin plugin;

    @Inject
    private void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Inject
    private void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getHand().equals(EquipmentSlot.HAND) &&
                player.getInventory().getItemInMainHand().getType().equals(Material.STICK) &&
                event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();
            Inventory playerInventory   = event.getPlayer().getInventory();
            Inventory villagerInventory = villager.getInventory();

            OpenInventoryTask task = new OpenInventoryTask(player, new VillagerInventory(playerInventory, villagerInventory));
            task.runTask(plugin);
        }
    }

    private class OpenInventoryTask extends BukkitRunnable {
        private Player player;
        private Inventory villagerInventory;

        OpenInventoryTask(Player player, Inventory villagerInventory) {
            this.player = player;
            this.villagerInventory = villagerInventory;
        }

        @Override
        public void run() {
            player.openInventory(villagerInventory);
        }
    }
}
