//package RateLimiter;
//
//// Use redis to store and retrive rate limting data.
//
//public class RedisRateLimiter implements RateLimiter {
//
//    private int maxRequests;
//    private Long windowSizeInMillis;
//
//    private Jedis jedis; // redis client
//
//    public RedisRateLimiter(int maxRequests, Long windowSizeInMillis) {
//        this.maxRequests = maxRequests;
//        this.windowSizeInMillis = windowSizeInMillis;
//        this.jedis = new Jedis("localhost");
//    }
//
//    @Override
//    public boolean allowRequests(String clientId) {
//        long currentTime = System.currentTimeMillis();
//        String key = "rate_limiter_" + clientId;
//
//        String lastRequestTimeStr = jedis.hget(key,"lastRequestTime");
//        String requestCountStr = jedis.hget(key,"requestCount");
//
//        int lastRequestTime = Integer.parseInt(lastRequestTimeStr);
//        int requestCount = Integer.parseInt(requestCountStr);
//
//        if(currentTime - lastRequestTime >= windowSizeInMillis) {
//            lastRequestTime  = currentTime;
//            requestCount  = 0;
//        }
//
//        if(requestCount < maxRequests) {
//            requestCount++;
//            jedis.hset(key,"lastRequestTime",currentTime);
//            jedis.hset(key,"requestCount",requestCount);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void updateConfig(int maxRequests, Long windowSizeInMillis) {
//
//    }
//}
