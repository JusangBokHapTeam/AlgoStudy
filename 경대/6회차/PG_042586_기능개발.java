package programmers;

import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/42586 )
 */
public class PG_042586_기능개발 {

    private class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Pair> queue = new LinkedList<>();
            for(int i = 0; i < progresses.length; i++) {
                queue.add(new Pair(progresses[i], speeds[i]));
            }

            Queue<Integer> ans = new LinkedList<>(); // 정답 저장
            Queue<Pair> temp = new LinkedList<>(); // 배포 예정
            while(!queue.isEmpty()) {
                int size = queue.size();
                int cnt = 0;
                boolean flag = true;
                while(size > cnt) {
                    Pair now = queue.poll();

                    // 배포 작업
                    if(flag && now.progress + now.speed >= 100) {
                        temp.add(new Pair(now.progress + now.speed, now.speed));
                    } else {
                        flag = false;
                        queue.add(new Pair(now.progress + now.speed, now.speed));
                    }
                    cnt++;
                }
                if(temp.size() > 0) {
                    ans.add(temp.size());
                    temp.clear();
                }
            }

            int[] answer = new int[ans.size()];
            int c = 0;
            while(!ans.isEmpty()) {
                answer[c++] = ans.poll();
            }

            return answer;
        }

        private class Pair {
            int progress;
            int speed;
            Pair(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }
        }
    }

}
