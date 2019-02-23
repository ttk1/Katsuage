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
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

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
    public void onPlayerInteractEntityEventHandler(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getHand().equals(EquipmentSlot.HAND) &&
                player.getInventory().getItemInMainHand().getType().equals(Material.STICK) &&
                event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();
            Inventory villagerInventory = villager.getInventory();

            /*
            logger.info(villager.toString());
            logger.info(villagerInventory.toString());

            ItemStack[] itemStacks = villagerInventory.getContents();
            for (int i = 0; i < itemStacks.length; i ++) {
                ItemStack itemStack = itemStacks[i];
                logger.info("index: "+i);
                if (itemStack != null) {
                    logger.info(itemStack.getType().toString());
                    logger.info(String.valueOf(itemStack.getAmount()));
                } else {
                    logger.info("null");
                }
            }
            */

            player.openInventory(new VillagerInventory(villagerInventory));
        }
    }
}
