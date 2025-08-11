import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList();
        
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.offer(days);
        }
        
        while (!queue.isEmpty()) {
            int days = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty() && days >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();    }

}
