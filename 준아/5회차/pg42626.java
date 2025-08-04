import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                break;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + (b * 2));
            cnt++;
        }
        
        if (pq.peek() >= K) {
            answer = cnt;
        }
        
        return answer;
    }
}
