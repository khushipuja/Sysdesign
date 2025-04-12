package RateLimiter;

public class RateLimiterManager {

    private static RateLimiterManager instance;
    private RateLimiter rateLimiter;

    private RateLimiterManager(){
        this.rateLimiter = new FixedWindowRateLimiter(1000000,2);
    }

    public static synchronized RateLimiterManager getInstance(){
        if(instance == null){
            instance = new RateLimiterManager();
        }
        return instance;
    }

    public boolean allowRequest(String clientID){
        return rateLimiter.allowRequests(clientID);
    }
}
