package RateLimiter;

public interface RateLimiter {
    public boolean allowRequests(String clientId);
    public void updateConfig(int maxRequests, Long windowSizeInMillis);
}
