package RateLimiter;

public class FixedWindowRateLimiterWithTemplate extends AbstractRateLimiter {

    @Override
    protected boolean isRequestAllowed(String clientId) {
        return false;
    }

    @Override
    public void updateConfig(int maxRequests, Long windowSizeInMillis) {

    }
}
