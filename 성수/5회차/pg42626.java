import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
  

    public static int solution(int[] scoville, int K) {
        int answer = 0;


        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        while(queue.peek() < K && queue.size() > 1) {

            if(queue.peek() >= K) {
                break;
            }

            Integer first = queue.poll();
            Integer second = queue.poll();

            int newFood = first + (second*2);
            queue.offer(newFood);
            answer += 1;

        }

        
         if(queue.size() == 1 && queue.peek() < K) {
            answer = -1;
        }

        return answer;
    }




}
