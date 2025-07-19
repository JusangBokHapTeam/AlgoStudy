import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/76502 )
 */
public class PG_076502_괄호회전하기 {

    private class Solution {
        public int solution(String s) {
            int answer = 0;

            for(int i = 0; i < s.length(); i++) {
                if(isValid(s)) answer++;
                s = s.substring(1) + s.charAt(0); // 맨 앞글자 뒤로 보내기
            }

            return answer;
        }


        /** 가지치기 없이 전부 체크
         * 테스트 1 〉	통과 (77.53ms, 87.6MB)
         * 테스트 2 〉	통과 (65.62ms, 94.3MB)
         * 테스트 3 〉	통과 (59.93ms, 79.5MB)
         * 테스트 4 〉	통과 (59.55ms, 81.8MB)
         * 테스트 5 〉	통과 (80.02ms, 81MB)
         * 테스트 6 〉	통과 (60.16ms, 83.3MB)
         * 테스트 7 〉	통과 (57.05ms, 85.3MB)
         * 테스트 8 〉	통과 (64.91ms, 82MB)
         * 테스트 9 〉	통과 (64.29ms, 83.9MB)
         * 테스트 10 〉	통과 (75.10ms, 81.5MB)
         * 테스트 11 〉	통과 (55.10ms, 82.6MB)
         * 테스트 12 〉	통과 (8.49ms, 85.9MB)
         * 테스트 13 〉	통과 (11.47ms, 75.5MB)
         * 테스트 14 〉	통과 (8.94ms, 83.7MB)
         */
        public boolean isValid(String str) {
            // 올바른 괄호를 만나면 pop
            Stack<Character> stack = new Stack();
            for(char c : str.toCharArray()) {
                if(!stack.isEmpty()) {
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            // 괄호가 올바르다면 스택은 비어있어야 함
            if(!stack.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }


        /** 가지치기 하면 조금 빨라짐..
         * 테스트 1 〉	통과 (39.77ms, 79.4MB)
         * 테스트 2 〉	통과 (27.97ms, 79.7MB)
         * 테스트 3 〉	통과 (23.43ms, 77.5MB)
         * 테스트 4 〉	통과 (18.93ms, 93.6MB)
         * 테스트 5 〉	통과 (38.88ms, 82.6MB)
         * 테스트 6 〉	통과 (22.85ms, 85.8MB)
         * 테스트 7 〉	통과 (24.15ms, 94.6MB)
         * 테스트 8 〉	통과 (31.54ms, 92.8MB)
         * 테스트 9 〉	통과 (42.37ms, 92.6MB)
         * 테스트 10 〉	통과 (36.92ms, 98.6MB)
         * 테스트 11 〉	통과 (42.18ms, 92.2MB)
         * 테스트 12 〉	통과 (11.64ms, 96.2MB)
         * 테스트 13 〉	통과 (12.18ms, 73.3MB)
         * 테스트 14 〉	통과 (9.50ms, 79.2MB)
         */
        public boolean isValid2(String str) {
            // 올바른 괄호를 만나면 pop
            Stack<Character> stack = new Stack();
            for(char c : str.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    // 스택 비어있으면 false
                    if (stack.isEmpty()) return false;

                    // 괄호 올바른지 판단
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }

            // 괄호가 올바르다면 스택은 비어있어야 함
            if(!stack.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
    }

}
