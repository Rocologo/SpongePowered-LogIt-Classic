package io.github.lucaseasedup.logit.common;

public enum CancelledState
{
    CANCELLED, NOT_CANCELLED;
    
    /**
     * Returns {@code true} if this state represents an operation
     * that has been externally cancelled by whatever means it would possibly become so.
     * 
     * @return {@code true} if cancelled; {@code false} otherwise.
     */
    public boolean isCancelled()
    {
        return this.equals(CANCELLED);
    }
}
