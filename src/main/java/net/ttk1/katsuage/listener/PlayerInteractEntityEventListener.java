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

@Singleton
public class PlayerInteractEntityEventListener implements Listener {
    private JavaPlugin plugin;

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
        else if (event.getRightClicked() instanceof Villager) {
            event.setCancelled(true);

            Villager villager = (Villager) event.getRightClicked();

            OpenMerchantTask task = new OpenMerchantTask(player, villager);
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

    private class OpenMerchantTask extends BukkitRunnable {
        private Player player;
        private Villager villager;

        OpenMerchantTask(Player player, Villager villager) {
            this.player = player;
            this.villager = villager;
        }

        @Override
        public void run() {
            if (villager.getCareer() == Villager.Career.NITWIT) {
                return;
            }

            if (!villager.isAdult()) {
                return;
            }

            player.openMerchant(villager, false);
        }
    }
}
