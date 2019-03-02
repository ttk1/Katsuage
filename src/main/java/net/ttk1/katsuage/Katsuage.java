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
    @Inject @Named("katsuage") private Logger logger;
    @Inject private Configuration config;

    @Inject private PlayerInteractEntityEventListener playerInteractEntityEventListener;
    @Inject private InventoryOpenEventListener inventoryOpenEventListener;
    @Inject private InventoryClickEventListener inventoryClickEventListener;

    @Override
    public void onEnable() {
        initConfig();

        PluginModule module = new PluginModule(this);
        Injector injector = module.createInjector();
        // createInjectorの時点でinjectは非明示的に行われているっぽいが、明示的なinjectもやっておく
        injector.injectMembers(this);

        getServer().getPluginManager().registerEvents(playerInteractEntityEventListener, this);
        getServer().getPluginManager().registerEvents(inventoryOpenEventListener, this);
        getServer().getPluginManager().registerEvents(inventoryClickEventListener, this);

        logger.info("Katsuage enabled");
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
}
