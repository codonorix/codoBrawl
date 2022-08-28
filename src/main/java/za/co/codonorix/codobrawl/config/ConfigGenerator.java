package za.co.codonorix.codobrawl.config;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigGenerator {
    public static void generateConfig(FileConfiguration config) {
        config.addDefault("location.World", null);
        config.addDefault("location.x", 0.0);
        config.addDefault("location.y", 0.0);
        config.addDefault("location.z", 0.0);
        config.addDefault("location.yaw", 0.0);
        config.addDefault("location.pitch", 0.0);

//        config.addDefault("arenas", null);
        config.options().copyDefaults(true);
    }
}
