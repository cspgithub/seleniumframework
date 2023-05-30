package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationFactory {

    public static FrameworkConfig getConfig() {

        return ConfigFactory.create(FrameworkConfig.class);

    }

}
