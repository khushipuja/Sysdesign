package RateLimiter;

public abstract class AbstractRateLimiter implements RateLimiter {

    private int maxRequests;
    private Long windowSizeInMilliSeconds;

    @Override
    public boolean allowRequests(String clientId) {
        return isRequestAllowed(clientId);
    }

    protected abstract boolean isRequestAllowed(String clientId);
}
