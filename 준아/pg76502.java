import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }
        
        for(int i = 0; i < s.length(); i++) {
            
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char c : queue) {
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isValid = false;
                        break;
                    }
                }
                else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        isValid = false;
                        break;
                    }
                }
                else {
                    stack.push(c);
                }
            }
            
            if (!stack.isEmpty()) {
                isValid = false;
            }
            
            if (isValid) {
                answer++;
            }
            
            queue.offer(queue.poll());
        }
        
        return answer;
    }
}
