import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/42626 )
 */
public class PG_042626_더맵게 {

    private class Solution {

        static Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        public int solution(int[] scoville, int K) {
            int answer = 0;

            for(int i = 0; i < scoville.length; i++) {
                pq.offer(scoville[i]);
            }

            while(true) {
                if(pq.size() <= 1) {
                    if(pq.peek() < K) {
                        answer = -1;
                    }
                    break;
                }
                int first = pq.poll();
                int second = pq.poll();

                if(first >= K) break;
                pq.offer(first + second * 2);
                answer++;
            }

            return answer;
        }
    }

}
