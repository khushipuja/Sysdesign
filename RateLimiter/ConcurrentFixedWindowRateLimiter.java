package RateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentFixedWindowRateLimiter implements RateLimiter {

    private  long windowSizeInMilliSeconds;
    private  int maxRequests;

    private ConcurrentHashMap<String, Long> windowStartTimes;
    private ConcurrentHashMap<String, AtomicInteger> requestCounts;

    public ConcurrentFixedWindowRateLimiter(long windowSizeInMilliSeconds, int maxRequests) {
        this.windowSizeInMilliSeconds = windowSizeInMilliSeconds;
        this.maxRequests = maxRequests;
        this.windowStartTimes = new ConcurrentHashMap<>();
        this.requestCounts = new ConcurrentHashMap<>();
    }


    @Override
    public boolean allowRequests(String clientId) {
        Long currentTime = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, currentTime);
        requestCounts.putIfAbsent(clientId, new AtomicInteger(0));

        if(currentTime - windowStartTimes.get(clientId) >= windowSizeInMilliSeconds) {
            windowStartTimes.put(clientId, currentTime);
            requestCounts.put(clientId, new AtomicInteger(0));
        }

        AtomicInteger requestCount = requestCounts.get(clientId);
        if(requestCount.get() < maxRequests) {
            requestCounts.put(clientId, new AtomicInteger(requestCount.incrementAndGet()));
            return true;
        }
        return false;

    }

    @Override
    public void updateConfig(int maxRequests, Long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMilliSeconds = windowSizeInMillis;
    }
}
