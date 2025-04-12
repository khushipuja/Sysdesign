package RateLimiter;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(String type , int maxRequest , Long windowSizeInSeconds) {
        return switch (type) {
            case "slidingWindow" -> new SlidingWindowRateLimiter(maxRequest, windowSizeInSeconds);
            case "fixedWindow" -> new FixedWindowRateLimiter(maxRequest, maxRequest);
            default -> null;
        };
    }
}
