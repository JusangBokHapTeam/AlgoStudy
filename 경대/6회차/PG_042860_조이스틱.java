package programmers;

import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/42860 )
 */
public class PG_042860_조이스틱 {

    static class Solution {

        public int solution(String name) {
            int answer = 0;

            ArrayList<Character> alphabet = new ArrayList<>();
            char cur = 'A';
            for (int i = 0; i < 26; i++) {
                alphabet.add(cur++);
            }

            int length = name.length();
            int move = length - 1; // 최소거리
            for(int i = 0; i < length; i++) {
                // 현재 글자 조작
                int index = alphabet.indexOf(name.charAt(i));
                answer += index <= 13 ? index : (26 - index);

                // 다음 글자 찾기 - A 연속되는 수 찾기
                int next = i + 1;
                while(next < length && name.charAt(next) == 'A') {
                    next++;
                }

                // 순서대로 vs 뒤돌기 최소이동 판단
                move = Math.min(move, i*2 + length - next);

                // 처음부터 뒷부분 먼저 입력하는 경우
                move = Math.min(move, (length - next)*2 + i);
            }
            answer += move;

            return answer;
        }
    }
}
