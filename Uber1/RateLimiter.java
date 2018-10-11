class RateLimiter {
    private int speedLimit;
    private int tokens;
    private long timestamp;

    RateLimiter(int tokensPerSecond) {
        this.speedLimit = tokensPerSecond;
        this.timestamp = System.currentTimeMillis();
    }

    public boolen acceptRqst() {
        long now = System.currentTimeMillis();
        tokens += (now - timestamp) * speedLimit / 1000;
        if (tokens > speedLimit) {
            tokens = speedLimit;
            return false;
        }
        timestamp = now;
        return true;
    }

    private boolean consumeToken(int consumeNum) {
        if (tokens < consumeNum) {
            return false;
        } else {
            tokens -= consumeNum;
        }
        return true;
    }
}
