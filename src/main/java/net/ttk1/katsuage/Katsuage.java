package net.ttk1.katsuage;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

import net.ttk1.katsuage.listener.*;

public class Katsuage extends JavaPlugin {
    private Logger logger;
    private Configuration config;
    private PlayerInteractEntityEventListener playerInteractEntityEventListener;
    private InventoryOpenEventListener inventoryOpenEventListener;

    public Katsuage() {
    }

    @Override
    public void onEnable() {
        initConfig();

        // injector
        PluginModule module = new PluginModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        // add event listener
        getServer().getPluginManager().registerEvents(playerInteractEntityEventListener, this);
        getServer().getPluginManager().registerEvents(inventoryOpenEventListener, this);

        logger.info("Katsuage enabled");
        logger.info((String) config.get("test", "test"));
    }

    @Override
    public void onDisable() {
        logger.info("Katsuage disabled");
    }

    private void initConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("config.yml found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Inject
    private void setLogger(@Named("katsuage") Logger logger) {
        this.logger = logger;
    }

    @Inject
    private void setConfig(Configuration config) {
        this.config = config;
    }

    @Inject
    private void setPlayerInteractEntityEventListener(PlayerInteractEntityEventListener playerInteractEntityEventListener) {
        this.playerInteractEntityEventListener = playerInteractEntityEventListener;
    }

    @Inject
    private void setInventoryOpenEventListener(InventoryOpenEventListener inventoryOpenEventListener) {
        this.inventoryOpenEventListener = inventoryOpenEventListener;
    }
}
