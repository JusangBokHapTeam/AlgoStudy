import java.util.*;

class Solution {
    
    class Process {
        
        private int priority;
        private int location;
        
        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        int answer = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
            pq.offer(priorities[i]);
        }
        
        List<Process> arr = new ArrayList<>();
        while(!queue.isEmpty()) {
            Process process = queue.poll();
            if (process.priority < pq.peek()) {
                queue.offer(process);
            } else {
                pq.poll();
                arr.add(process);
            }
        }
        
        for (int i = 0;i < priorities.length; i++) {
            if (arr.get(i).location == location) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}
