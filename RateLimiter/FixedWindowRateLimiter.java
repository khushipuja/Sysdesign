package RateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedWindowRateLimiter implements RateLimiter {

    private  long windowSizeInMilliSeconds;
    private  int maxRequests;

    private Map<String, Long> windowStartTimes;
    private Map<String, Integer> requestCounts;
    private ScheduledExecutorService scheduledExecutorService;

    public FixedWindowRateLimiter(long windowSizeInMilliSeconds,int maxRequests) {
        this.windowSizeInMilliSeconds = windowSizeInMilliSeconds;
        this.maxRequests = maxRequests;
        this.windowStartTimes = new HashMap<>();
        this.requestCounts = new HashMap<>();
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        startCleanUpTask();
    }

    public void startCleanUpTask() {
        scheduledExecutorService.scheduleAtFixedRate(()->{

            long currentTime = System.currentTimeMillis();
            for (Map.Entry<String, Long> entry : windowStartTimes.entrySet()) {
                if(currentTime - entry.getValue() > windowSizeInMilliSeconds) {
                    System.out.println("Clean up window at " + entry.getKey());
                    windowStartTimes.remove(entry.getKey());
                    requestCounts.remove(entry.getKey());
                }
            }

        },windowSizeInMilliSeconds,windowSizeInMilliSeconds, TimeUnit.MILLISECONDS);
    }


    @Override
    public boolean allowRequests(String clientId) {
        Long currentTime = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, currentTime);
        requestCounts.putIfAbsent(clientId, 0);

        if(currentTime - windowStartTimes.get(clientId) >= windowSizeInMilliSeconds) {
            windowStartTimes.put(clientId, currentTime);
            requestCounts.put(clientId, 0);
        }

        int requestCount = requestCounts.get(clientId);
        if(requestCount < maxRequests) {
            requestCounts.put(clientId, requestCount + 1);
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
