package net.ttk1.katsuage.listener;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

import static org.bukkit.event.inventory.InventoryAction.*;

@Singleton
public class InventoryClickEventListener implements Listener {
    @Inject
    private Logger logger;

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        InventoryAction action = event.getAction();
        ItemStack current = event.getCurrentItem();
        ItemStack cursor = event.getCursor();

        if (current != null && action == PICKUP_HALF) {
            // イベントのキャンセル
            event.setCancelled(true);
            // インベントリ、カーソルの更新
            cursor.setType(current.getType());
            cursor.setAmount(current.getAmount() - current.getAmount() / 2);
            current.setAmount(current.getAmount() / 2);
            event.setCurrentItem(current);
            player.setItemOnCursor(cursor);
        }
    }
}
