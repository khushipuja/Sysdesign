package RateLimiter;

public class Main {

    public static void main(String[] args) {
        RateLimiter fixedWindowRateLimiter = RateLimiterFactory.createRateLimiter("fixedWindow",10,59000L);
        RateLimiter slidingWindowRateLimiter = RateLimiterFactory.createRateLimiter("slidingWindow",10,69000L);

        //Testing fixed window counter
        for(int i = 0 ; i < 12 ; i++){
            System.out.println(fixedWindowRateLimiter.allowRequests("client1"));
        }

        //Testing sliding window rate limiter
        for(int i = 0 ; i < 12 ; i++){
            System.out.println(slidingWindowRateLimiter.allowRequests("client1"));
        }
    }
}
