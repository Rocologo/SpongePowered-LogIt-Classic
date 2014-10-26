package io.github.lucaseasedup.logit;

import io.github.lucaseasedup.logit.common.FatalReportedException;
import java.io.IOException;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "LogIt", name = "LogIt", version = "SNAPSHOT")
public final class LogItPlugin
{
    public void onEnable(ServerStartingEvent event)
    {
        // TODO:
        // - Load messages
        // - register /logit command
        
        core = LogItCore.getInstance();
        
        try
        {
            core.start();
        }
        catch (FatalReportedException ex)
        {
            disable();
        }
    }
    
    public void onDisable(ServerStoppingEvent event)
    {
        if (core != null)
        {
            if (core.isStarted())
            {
                core.stop();
            }
            
            core = null;
        }
        
        // TODO
    }
    
    private void enable()
    {
        // TODO
    }
    
    private void disable()
    {
        // TODO
    }
    
    public void reloadMessages(String prefix) throws IOException
    {
        loadMessages(prefix);
    }
    
    private void loadMessages(String prefix) throws IOException
    {
        // TODO
    }

    private void loadCustomGlobalMessages(String path) throws IOException
    {
        // TODO
    }
    
    private void loadCustomLocalMessages(String path) throws IOException
    {
        // TODO
    }
    
    public static String getMessage(String label)
    {
        // TODO
        return null;
    }
    
    public String replaceGlobalTokens(String message)
    {
        // TODO
        return null;
    }

    public static String getCraftBukkitVersion()
    {
        // TODO
        return null;
    }
    
    /* package */ static LogItPlugin getInstance()
    {
        // TODO
        return null;
    }
    
    private static LogItPlugin instance = null;
    private LogItCore core;
}
