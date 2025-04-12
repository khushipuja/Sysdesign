package RateLimiter;

// Good for burst of traffic
public class TokenBucketRateLimiter implements RateLimiter {

    int maxTokens;
    int currentTokens;
    int refillRate;
    long lastRefillTimestamp;

    public TokenBucketRateLimiter(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.currentTokens = maxTokens;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }


    @Override
    public boolean allowRequests(String clientId) {
        long currentTimestamp = System.currentTimeMillis();
         updateTokens(currentTimestamp);

        if(currentTokens >0) {
            currentTokens--;
            return true;
        }
        return false;
    }

    private void updateTokens(long currentTimestamp) {
        int diff = (int) (currentTimestamp - lastRefillTimestamp);
        int tokensToAdd = diff / refillRate;
        currentTokens = Math.min(maxTokens , currentTokens + tokensToAdd);
        lastRefillTimestamp = currentTimestamp;
    }

    @Override
    public void updateConfig(int maxRequests, Long windowSizeInMillis) {

    }
}
