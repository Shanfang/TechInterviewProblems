
/*
referenced this post from 1point3acers
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=448630
class Logger {
        Queue<Node> q = new ArrayDeque<>();
        HashMap<String,Integer> dict = new HashMap<>(); // ip, called Times.
        public Logger() {}
        public boolean ipLimiter(double timestamp, String ip, int callTimes){
            while ( !q.isEmpty() && timestamp - q.peek().time >= 1){
                Node t = q.poll();
                dict.remove(t.ip);
            }.
            if(!dict.contains(ip)){
                if(callTimes > 100){
                    return false;
                }. visit 1point3acres for more.
                q.offer(new Node(timestamp, ip));
                dict.add(ip,callTimes);
                return true;
            }else{
                if(dict.get(ip) + callTimes <= 100){
                    dict.put(ip, dict.get(ip) + callTimes);
                    return true;
                }
            }
            return false;
        }

        private static class Node{
            double time;
            String ip;
            public Node(double t, String ip){
                this.time = t;
                this.ip = ip;
            }
        }
}

*/
class RateLimiter2 {
        Queue<Node> q;
        HashMap<String,Integer> dict; // ip, called Times.
        public RateLimiter2() {
            q = new ArrayDeque<>();
            dict = new HashMap<>();
        }

        public boolean ipLimiter(double timestamp, String ip, int callTimes){
            while ( !q.isEmpty() && timestamp - q.peek().time >= 1){
                Node t = q.poll();
                dict.put(t.ip, dict.get(t.ip) - 1);
                if (dict.get(t.ip) == 0) {
                    dict.remove(t.ip);
                }
            }
            if(!dict.contains(ip)){
                if(callTimes > 100){
                    return false;
                }
                q.offer(new Node(timestamp, ip));
                dict.put(ip,callTimes);
                return true;
            }else{
                if(dict.get(ip) + callTimes <= 100){
                    dict.put(ip, dict.get(ip) + callTimes);
                    return true;
                }
            }
            return false;
        }

        private static class Node{
            double time;
            String ip;
            public Node(double t, String ip){
                this.time = t;
                this.ip = ip;
            }
        }
}
