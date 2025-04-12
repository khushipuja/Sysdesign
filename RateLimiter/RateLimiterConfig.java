package RateLimiter;

import java.util.ArrayList;
import java.util.List;

public class RateLimiterConfig {

    int maxRequests;
    Long windowSizeInMilliSeconds;
    List<RateLimiter> observers;

    public RateLimiterConfig(int maxRequests, Long windowSizeInMilliSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMilliSeconds = windowSizeInMilliSeconds;
        this.observers = new ArrayList<>();
    }

    public void register(RateLimiter observer) {
        observers.add(observer);
    }

    public void update(int maxRequests, Long windowSizeInMilliSeconds) {
        for (RateLimiter observer : observers) {
            observer.updateConfig(maxRequests, windowSizeInMilliSeconds);
        }
    }
}
