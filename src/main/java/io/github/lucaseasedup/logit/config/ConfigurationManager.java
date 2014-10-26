package io.github.lucaseasedup.logit.config;

import io.github.lucaseasedup.logit.LogItCoreObject;
import java.util.HashMap;
import java.util.Map;

public final class ConfigurationManager extends LogItCoreObject
{
    // TODO

    public PredefinedConfiguration getConfiguration(String filename)
    {
        if (filename == null)
            throw new IllegalArgumentException();
        
        return registrations.get(filename);
    }
    
    private Map<String, PredefinedConfiguration> registrations =
            new HashMap<>();
}
