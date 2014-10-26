package io.github.lucaseasedup.logit;

import static io.github.lucaseasedup.logit.message.MessageHelper.t;
import io.github.lucaseasedup.logit.account.AccountManager;
import io.github.lucaseasedup.logit.account.AccountWatcher;
import io.github.lucaseasedup.logit.backup.BackupManager;
import io.github.lucaseasedup.logit.command.LogItTabCompleter;
import io.github.lucaseasedup.logit.common.CancelledState;
import io.github.lucaseasedup.logit.common.FatalReportedException;
import io.github.lucaseasedup.logit.config.ConfigurationManager;
import io.github.lucaseasedup.logit.config.PredefinedConfiguration;
import io.github.lucaseasedup.logit.cooldown.CooldownManager;
import io.github.lucaseasedup.logit.locale.LocaleManager;
import io.github.lucaseasedup.logit.logging.CommandSilencer;
import io.github.lucaseasedup.logit.logging.LogItCoreLogger;
import io.github.lucaseasedup.logit.message.LogItMessageDispatcher;
import io.github.lucaseasedup.logit.persistence.PersistenceManager;
import io.github.lucaseasedup.logit.security.GlobalPasswordManager;
import io.github.lucaseasedup.logit.security.SecurityHelper;
import io.github.lucaseasedup.logit.session.SessionManager;
import java.io.File;
import java.util.logging.Level;
import org.spongepowered.api.entity.Player;

public final class LogItCore
{
    private LogItCore(LogItPlugin plugin)
    {
        if (plugin == null)
            throw new IllegalArgumentException();
        
        this.plugin = plugin;
    }
    
    public CancelledState start() throws FatalReportedException
    {
        if (isStarted())
        {
            throw new IllegalStateException(
                    "The LogIt core has already been started."
            );
        }
        
        // TODO: event
        // TODO: make data folder
        // TODO: set firstRun
        
        setUpConfiguration();
        setUpLogger();
        

        if (isFirstRun())
        {
            doFirstRunStuff();
        }

        setUpLocaleManager();
        setUpAccountManager();
        setUpPersistenceManager();

        securityHelper = new SecurityHelper();
        backupManager = new BackupManager(getAccountManager());
        sessionManager = new SessionManager();
        messageDispatcher = new LogItMessageDispatcher();
        tabCompleter = new LogItTabCompleter();
        
        if (getConfig("config.yml").getBoolean("profiles.enabled"))
        {
            setUpProfileManager();
        }

        globalPasswordManager = new GlobalPasswordManager();
        cooldownManager = new CooldownManager();
        accountWatcher = new AccountWatcher();
        // TODO: tabApiWrapper init
        
        // TODO: tab initializeb block
        
        startTasks();
        enableCommands();
        registerEventListeners();
        
        started = true;
        
        log(Level.FINE, t("startPlugin.success"));
        
        if (isFirstRun())
        {
            tellConsole(t("firstRun1"));
            tellConsole(t("firstRun2"));
            tellConsole(t("firstRun3"));
        }
        
        // TODO: Greet all online players
        
        return CancelledState.NOT_CANCELLED;
    }
    
    private void setUpConfiguration() throws FatalReportedException
    {
        // TODO
    }

    private void setUpLogger()
    {
        // TODO
    }

    private void doFirstRunStuff()
    {
        // TODO
    }

    private void setUpLocaleManager()
    {
        // TODO
    }

    private void setUpAccountManager() throws FatalReportedException
    {
        // TODO
    }

    private void setUpPersistenceManager() throws FatalReportedException
    {
        // TODO
    }

    private void setUpProfileManager()
    {
        // TODO
    }

    private void startTasks()
    {
        // TODO
    }

    private void scheduleTask(Runnable runnable, long delay, long period)
    {
        // TODO
    }

    private void enableCommands()
    {
        // TODO
    }

    private void registerEventListeners()
    {
        // TODO
    }
    
    public void stop()
    {
        if (!isStarted())
            throw new IllegalStateException("The LogIt core is not started.");
        
        // TODO: farewell to everyone
        
        disableCommands();
        
        // TODO: unregister serializers
        // TODO: close account storage
        // TODO: cancel tasts, unregister listeners

        started = false;
        
        dispose();
        
        log(Level.FINE, t("stopPlugin.success"));
        
        if (logger != null)
        {
            //logger.close();
            logger = null;
        }
    }

    private void disableCommands()
    {
        // TODO
    }
    
    private void dispose()
    {
        if (isStarted())
        {
            throw new IllegalStateException(
                    "Cannot dispose the LogIt core while it's running."
            );
        }
        
        if (configurationManager != null)
        {
            configurationManager.dispose();
            configurationManager = null;
        }
        
        if (commandSilencer != null)
        {
            commandSilencer.dispose();
            commandSilencer = null;
        }
        
        if (localeManager != null)
        {
            localeManager.dispose();
            localeManager = null;
        }
        
        if (accountManager != null)
        {
            accountManager.dispose();
            accountManager = null;
        }
        
        if (persistenceManager != null)
        {
            persistenceManager.dispose();
            persistenceManager = null;
        }
        
        securityHelper = null;
        
        if (backupManager != null)
        {
            backupManager.dispose();
            backupManager = null;
        }
        
        if (sessionManager != null)
        {
            sessionManager.dispose();
            sessionManager = null;
        }
        
        if (messageDispatcher != null)
        {
            messageDispatcher.dispose();
            messageDispatcher = null;
        }
        
        if (tabCompleter != null)
        {
            tabCompleter.dispose();
            tabCompleter = null;
        }
        
        if (globalPasswordManager != null)
        {
            globalPasswordManager.dispose();
            globalPasswordManager = null;
        }
        
        if (cooldownManager != null)
        {
            cooldownManager.dispose();
            cooldownManager = null;
        }
        
        if (accountWatcher != null)
        {
            accountWatcher.dispose();
            accountWatcher = null;
        }
        
        // TODO: tabApiWrapper & tabListUpdater
    }
    
    public void restart() throws FatalReportedException
    {
        if (!isStarted())
            throw new IllegalStateException("The LogIt core is not started.");
        
        // TODO: export sessions
        
        stop();
        
        if (!start().isCancelled())
        {
            // TODO: reload messages
            // import sessions

            log(Level.INFO, t("reloadPlugin.success"));
        }
    }
    
    public boolean isPlayerForcedToLogIn(Player player)
    {
        // TODO
        return true;
    }
    
    public void updatePlayerGroup(Player player)
    {
        // TODO
    }

    public void log(Level level, String msg)
    {
        // TODO
    }

    public void log(Level level, String msg, Throwable throwable)
    {
        // TODO
    }

    public void log(Level level, Throwable throwable)
    {
        // TODO
    }

    public void tellConsole(String msg)
    {
        // TODO
    }
    
    public File getDataFolder()
    {
        return null;
    }
    
    public File getDataFile(String path)
    {
        return null;
    }
    
    public boolean isFirstRun()
    {
        return firstRun;
    }
    
    public boolean isStarted()
    {
        return started;
    }

    public ConfigurationManager getConfigurationManager()
    {
        return configurationManager;
    }
    
    public PredefinedConfiguration getConfig(String filename)
    {
        if (filename == null)
            throw new IllegalArgumentException();
        
        if (getConfigurationManager() == null)
            return null;
        
        return getConfigurationManager().getConfiguration(filename);
    }

    // TODO: getWaitingRoomLocation()
    
    private LogItCoreLogger getLogger()
    {
        return logger;
    }
    
    public LocaleManager getLocaleManager()
    {
        return localeManager;
    }
    
    public AccountManager getAccountManager()
    {
        return accountManager;
    }
    
    public PersistenceManager getPersistenceManager()
    {
        return persistenceManager;
    }
    
    public SecurityHelper getSecurityHelper()
    {
        return securityHelper;
    }
    
    public BackupManager getBackupManager()
    {
        return backupManager;
    }
    
    public SessionManager getSessionManager()
    {
        return sessionManager;
    }
    
    public LogItMessageDispatcher getMessageDispatcher()
    {
        return messageDispatcher;
    }
    
    public LogItTabCompleter getTabCompleter()
    {
        return tabCompleter;
    }
    
    public GlobalPasswordManager getGlobalPasswordManager()
    {
        return globalPasswordManager;
    }
    
    public CooldownManager getCooldownManager()
    {
        return cooldownManager;
    }
    
    private AccountWatcher getAccountWatcher()
    {
        return accountWatcher;
    }
    
    // TODO: getEventListener()
    
    public LogItPlugin getPlugin()
    {
        return plugin;
    }
    
    public static LogItCore getInstance()
    {
        if (instance == null)
        {
            instance = new LogItCore(LogItPlugin.getInstance());
        }
        
        return instance;
    }
    
    private static volatile LogItCore instance = null;
    
    private final LogItPlugin plugin;
    private boolean firstRun;
    private boolean started = false;

    private ConfigurationManager configurationManager;
    private LogItCoreLogger logger;
    private CommandSilencer commandSilencer;
    private LocaleManager localeManager;
    private AccountManager accountManager;
    private PersistenceManager persistenceManager;
    private SecurityHelper securityHelper;
    private BackupManager backupManager;
    private SessionManager sessionManager;
    private LogItMessageDispatcher messageDispatcher;
    private LogItTabCompleter tabCompleter;
    private GlobalPasswordManager globalPasswordManager;
    private CooldownManager cooldownManager;
    private AccountWatcher accountWatcher;
    // TODO: tabApi & updater
    
    // TODO: tasks field
    // TODO: eventListeners map Map<Class<? extends Listener>, Listener>
}
