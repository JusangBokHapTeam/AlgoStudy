package programmers;

import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/42587 )
 */
public class PG_042587_프로세스 {

    private class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Node> q = new LinkedList<>();
            for(int i = 0; i < priorities.length; i++) {
                q.add(new Node(i, priorities[i]));
            }

            while(!q.isEmpty()) {
                Node now = q.poll();

                // 프로세스 중요도 높은것이 있는지 판단
                Iterator<Node> it = q.iterator();
                boolean flag = true;
                while(it.hasNext()) {
                    Node next = it.next();
                    if(next.p > now.p) {
                        flag = false;
                        break;
                    }
                }

                // 높은것이 없다면 실행 있으면 다시 큐에 넣기
                if(flag) {
                    answer++;
                    if(now.i == location) {
                        break;
                    }
                } else {
                    q.add(now);
                }
            }

            return answer;
        }

        private class Node {
            int i;
            int p;
            Node(int i, int p) {
                this.i = i;
                this.p = p;
            }
        }
    }

}
