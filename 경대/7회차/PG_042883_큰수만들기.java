package programmers;

import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/42883 )
 */
public class PG_042883_큰수만들기 {

    private class Solution {
        public String solution(String number, int k) {
            String answer = "";
            int print = number.length() - k;

            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < number.length(); i++) {
                int now = Character.getNumericValue(number.charAt(i));
                while(!stack.isEmpty() && k > 0 && stack.peek() < now) {
                    stack.pop();
                    k--;
                }
                stack.push(now);
            }

            Iterator<Integer> it = stack.iterator();
            while(it.hasNext() && print > 0) {
                answer += Integer.toString(it.next());
                print--;
            }

            return answer;
        }
    }

}
