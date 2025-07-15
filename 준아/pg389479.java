import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    class Server {
        private int time;
        private int cnt;
        
        public Server(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        
        int totalServerCnt = 1;
        Queue<Server> queue = new LinkedList<>();
        for (int i = 0; i < players.length; i++) {
            
            if (!queue.isEmpty() && queue.peek().time == i) {
                Server server = queue.poll();
                totalServerCnt -= server.cnt;
            }
            
            if (totalServerCnt * m > players[i]) {
                continue;
            } 
            
            int time = i + k;
            int needPlayerCnt = players[i] - (totalServerCnt * m - 1);
            int needServerCnt = needPlayerCnt / m;
            if (needPlayerCnt % m > 0) {
                needServerCnt++;
            }
            queue.offer(new Server(time, needServerCnt));
            totalServerCnt += needServerCnt;
            answer += needServerCnt;
        }
        
        return answer;
    }
}
