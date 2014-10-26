package io.github.lucaseasedup.logit.message;

import io.github.lucaseasedup.logit.LogItPlugin;

public final class MessageHelper
{
    private MessageHelper()
    {
    }
    
    /**
     * Returns the translated message associated with the given label.
     * 
     * @param label the message label.
     * 
     * @return the translated message.
     */
    public static String t(String label)
    {
        return LogItPlugin.getMessage(label);
    }
    
    // TODO
}
