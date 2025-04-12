package RateLimiter;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimiter {

    private  long windowSize;
    private  int maxRequests;
    private final Map<String , Queue<Long>> requestsTimes;

    public SlidingWindowRateLimiter(int maxRequests,long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.requestsTimes = new HashMap<>();
    }

    @Override
    public boolean allowRequests(String clientId) {
        requestsTimes.putIfAbsent(clientId, new ArrayDeque<>());
        Queue<Long> requests = requestsTimes.get(clientId);
        Long currentTime = System.currentTimeMillis();
        while(!requests.isEmpty() && currentTime - requests.peek() > windowSize) {
            requests.poll();
        }
        if(requests.size() < maxRequests) {
            requests.add(currentTime);
        }
        else return false;
        requestsTimes.put(clientId, requests);
        return true;
    }

    @Override
    public void updateConfig(int maxRequests, Long windowSizeInMillis) {
        this.windowSize = windowSizeInMillis;
        this.maxRequests = maxRequests;
    }
}
